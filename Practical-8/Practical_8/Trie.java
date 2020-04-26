package org.algorithms.thomasogara.Practical_8;

import java.util.Arrays;
import java.util.function.Function;

public class Trie {
    // Alphabet size (# of symbols) we pick 26 for English alphabet
    static final int ALPHABET_SIZE = 26;
    static TrieNode root;

    // If not key present, inserts into trie
    // If the key is prefix of Trie node,
    // marks leaf node
    static void insert(String key) {
        char[] chars = key.toCharArray();
        TrieNode currentNode = root;
        for(int i = 0; i < chars.length; i++){
            if(currentNode.children[chars[i] - 'a'] == null){
                TrieNode newNode = new TrieNode();
                currentNode.children[chars[i] - 'a'] = newNode;
            }
            currentNode = currentNode.children[chars[i] - 'a'];
        }
        currentNode.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key) {
        char[] chars = key.toCharArray();
        TrieNode currentNode = root;
        boolean found = true;
        for(int i = 0; i < chars.length; i++){
            if(currentNode.children[chars[i] - 'a'] != null){
                currentNode = currentNode.children[chars[i] - 'a'];
            }else{
                found = false;
                break;
            }
        }
        return found && currentNode.isEndOfWord;
    }

    // Driver
    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt",
                "silver"};
        String[] output = {"Not present in trie", "Present in trie"};
        root = new TrieNode();
        // Construct trie
        int i;
        Arrays.stream(keys).parallel().forEach(Trie::insert);
        // Search for different keys
        System.out.println("The words contained in this trie are: " + Arrays.toString(keys));
        System.out.println("Is \"book\" present in the Trie?: " + (search("book") ? output[1] : output[0]));
        System.out.println("Is \"recursion\" present in the Trie?: " + (search("recursion") ? output[1] : output[0]));
        System.out.println("Is \"film\" present in the Trie?: " + (search("film") ? output[1] : output[0]));
        System.out.println("Is \"films\" present in the Trie?: " + (search("films") ? output[1] : output[0]));
        System.out.println("Is \"algorithm\" present in the Trie?: " + (search("algorithm") ? output[1] : output[0]));
        System.out.println("Is \"bring\" present in the Trie?: " + (search("bring") ? output[1] : output[0]));
        System.out.println("Is \"trie\" present in the Trie?: " + (search("trie") ? output[1] : output[0]));
    }

    // class for Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node represents end of a word i.e. leaf node
        boolean isEndOfWord;
    }
}