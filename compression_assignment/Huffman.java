package compression_assignment;

/******************************************************************************
 *  Compilation:  javac CompressionAssignment.Huffman.java
 *
 *  Compress or expand a binary input stream using the CompressionAssignment.Huffman algorithm.
 *
 * Add instructions and documentation related to your CompressionAssignment.Huffman algorithm here...
 *
 ******************************************************************************/


import sun.nio.cs.US_ASCII;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *  @author Thomas O'Gara
 *  @author Luke Connelly
 */

public class Huffman {

    // alphabet size of extended ASCII
    private static final int R = 256;

    // Do not instantiate.
    private Huffman() { }

    // CompressionAssignment.Huffman trie node
    private static class Node implements Comparable<Node> {
        private final byte b;
        private final int freq;
        private final Node left, right;

        Node(byte b, int freq, Node left, Node right) {
            this.b    = b;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }

        public String toString(){
            String leftString = isLeaf() ? "none" : left.toString();
            String rightString = isLeaf() ? "none" : right.toString();
            return "Byte: "+ b
                    +" Freq: "+ freq
                    +" Left: (" + leftString
                    +") Right: (" + rightString+")";
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using CompressionAssignment.Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress(){
        // read in from stdin
        String input = StdIn.readAll();

        // calculate the frequencies for each character
        int[] frequencies = getFrequencies(input);

        // build the tree using the frequencies provided
        Node root = buildTrie(frequencies);

        // build the lookup table from the tree
        String[] lookupTable = new String[R];
        buildCode(lookupTable, root, "");

        // write the trie to stdout for the decoder
        writeTrie(root);

        for(byte b : input.getBytes()){
            int i = Byte.toUnsignedInt(b);
            for(char x : lookupTable[i].toCharArray()){
                BinaryStdOut.write(x == '1');
            }
        }

    }


    /**
     * Reads a sequence of bits that represents a CompressionAssignment.Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress(){
        Node trie = readTrie();
        //System.out.println(trie.toString());
        //System.out.println(input);

       ArrayList<Byte> bytes = new ArrayList<>();
        while (!BinaryStdIn.isEmpty()){
            decode(trie, bytes);
        }
        bytes.remove(bytes.size() - 1);
        byte[] byteArray = new byte[bytes.size()];
        for(int i = 0; i < byteArray.length; i++){
            byteArray[i] = bytes.get(i);
        }
        for(byte b : byteArray){
            BinaryStdOut.write(b);
        }

    }

    public static void decode(Node x, ArrayList<Byte> bytes){
        if(BinaryStdIn.isEmpty()) return;
        if(!x.isLeaf()){
            if(!BinaryStdIn.readBoolean()){
                decode(x.left, bytes);
            }else{
                decode(x.right, bytes);
            }
        }
        if(x.b != (byte) 0) bytes.add(x.b);
    }

    private static int[] getFrequencies(String input){
        int[] frequencies = new int[R];
        for(Byte b : input.getBytes()){
            // map all bytes to range 0 - 255
            int i = Byte.toUnsignedInt(b);
            frequencies[i] += 1;
        }
        return frequencies;
    }

    // build the CompressionAssignment.Huffman trie given frequencies
    private static Node buildTrie(int[] freq) {

        // initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<>();
        for (int i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node((byte)i, freq[i], null, null));

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.insert(new Node((byte) 0, 0, null, null));
            else                 pq.insert(new Node((byte) 1, 0, null, null));
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node((byte) 0, left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }


    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.b);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[Byte.toUnsignedInt(x.b)] = s;
        }
    }



    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readByte(), -1, null, null);
        }
        else {
            return new Node((byte) 0, -1, readTrie(), readTrie());
        }
    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" an {@code decompress()} if it is "decompress".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws IOException {
        if(args.length < 2){
            usage();
            return;
        }
        System.setIn(new FileInputStream(new File(args[1])));
        System.setOut(new PrintStream(new FileOutputStream(new File(args[2]))));
        switch (args[0]){
            case "compress":
                long ctime = System.nanoTime();
                compress();
                ctime = System.nanoTime()-ctime;
                BinaryStdIn.close();
                BinaryStdOut.close();
                System.setOut(new PrintStream(new FileOutputStream(new File("timings.txt"))));
                //System.out.println("Time taken to compress: "+ctime);
                break;
            case "decompress":
                long dtime = System.nanoTime();
                decompress();
                BinaryStdIn.close();
                BinaryStdOut.close();
                dtime = System.nanoTime()-dtime;
                System.setOut(new PrintStream(new FileOutputStream(new File("timings.txt"))));
                System.out.println("Time taken to decompress: "+dtime);
                break;
            default:
                usage();
                break;
        }
    }

    public static void usage(){
        System.out.println("Please enter arguments in the form: (de)compress path/filename path/fileToWriteTo");
        System.out.println("Sample inputs:");
        System.out.println("compress mobydick.txt mobydickcompressed.txt");
        System.out.println("decompress mobydickcompressed.txt mobydick.txt");
        System.out.println("compress data/mobydick.txt data/compressedFiles/mobydickcompressed.txt");
        System.out.println("decompress /Users/Luke/Downloads/mobydickcompressed.txt /Users/Luke/Downloads/mobydick.txt");
    }
}

