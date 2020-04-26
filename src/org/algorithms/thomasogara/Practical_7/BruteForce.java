package org.algorithms.thomasogara.Practical_7;
// Java program for Naive Pattern Searching 

import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce {

    public static int[] search(String text, String pattern) {
        int searchLength = text.length();
        int patternLength = pattern.length();
		ArrayList<Integer> indices = new ArrayList<>();
		for(int i = 0; i <= searchLength - patternLength; i++){
			int j = 0;
			while(j < patternLength && text.charAt(i + j) == pattern.charAt(j)){
				j++;
			}
			if(j == patternLength) indices.add(i);
		}

		int[] indicesArr = new int[indices.size()];
		for(int i = 0; i < indices.size(); i++){
			indicesArr[i] = indices.get(i);
		}
		return indicesArr;
    }
}
