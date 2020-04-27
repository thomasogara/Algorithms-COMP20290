package org.algorithms.thomasogara.Practical_7;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try {
            String[] testStrings = readTestFile();
            String[] testPatterns = readPatternFile();

            System.out.println("Beginning testing of KMP search algorithm");
            for(String patternString : testPatterns){
                for(String testString : testStrings){
                    long start = System.nanoTime();
                    KMP.search(testString, patternString);
                    long elapsed = System.nanoTime() - start;
                    System.out.println(elapsed);
                }
            }

            System.out.println("Beginning testing of Brute Force search algorithm");
            for(String patternString : testPatterns){
                for(String testString : testStrings){
                    long start = System.nanoTime();
                    BruteForce.search(testString, patternString);
                    long elapsed = System.nanoTime() - start;
                    System.out.println(elapsed);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String[] readTestFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("assets/Practical_7/testStrings.txt")));
        LinkedList<String> ll = new LinkedList<>();
        String line = null;
        while((line = br.readLine()) != null){
            ll.add(line);
        }
        br.close();
        String[] lines = new String[ll.size()];
        int i = 0;
        while(!ll.isEmpty()){
            lines[i++] = ll.removeFirst();
        }
        return lines;
    }

    public static String[] readPatternFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("assets/Practical_7/testPatterns.txt")));
        LinkedList<String> ll = new LinkedList<>();
        String line = null;
        while((line = br.readLine()) != null){
            ll.add(line);
        }
        br.close();
        String[] lines = new String[ll.size()];
        int i = 0;
        while(!ll.isEmpty()){
            lines[i++] = ll.removeFirst();
        }
        return lines;
    }
}
