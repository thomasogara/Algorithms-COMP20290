package Practical_7;


// JAVA program for implementation of KMP pattern
// searching algorithm

import java.util.ArrayList;
import java.util.Arrays;

public class KMP {
    static int[] search(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);
        ArrayList<Integer> matches = new ArrayList<>();

        for(int i = 0; i <= txt.length() - pat.length();){
            int j = 0;
            while(j < pat.length() && txt.charAt(i + j) == pat.charAt(j)) j++;
            if(j != pat.length()){
                i += lps[j] + 1;
            }else {
                matches.add(i);
                i++;
            }

        }

        int[] matchesArr = new int[matches.size()];
        for(int i = 0; i < matches.size(); i++){
            matchesArr[i] = matches.get(i);
        }
         return matchesArr;

    }

    static void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}