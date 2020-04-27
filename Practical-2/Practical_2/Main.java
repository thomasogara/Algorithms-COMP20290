package org.algorithms.thomasogara.Practical_2;

import java.util.Scanner;

public class Main {
    public static void run(String filename) {
        String[] args = {filename};
        System.out.println("Input file: " + filename);
        System.out.println("ThreeSumA running time:");
        ThreeSumA.main(args);
        System.out.println("ThreeSumB running time:");
        ThreeSumB.main(args);
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Practical 2 demonstration program!");
        System.out.println("NOTICE: The running time for ThreeSumA on inputs > 2,000 items is measured in tens of minutes");
        System.out.println("I'd recommend simply quitting once the program starts processing 4Kints.txt\n");
        for(String arg : args){
            System.out.println("Would you like to run ThreeSumA and ThreeSumB for the input file " + arg + "?");
            System.out.println("If yes, enter 'Y'. Else, enter 'N'");
            while(!sc.hasNext("Y|N")){
                System.out.println("Sorry, that wasn't recognised");
                System.out.println("Would you like to run ThreeSumA and ThreeSumB for the input file " + arg + "?");
                System.out.println("If yes, enter 'Y'. Else, enter 'N'");
            }
            if(sc.next().equals("N")) continue;
            run(arg);
        }
    }
}
