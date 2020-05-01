package org.algorithms.thomasogara.Practical_1;

/**
 * @author: Thomas O'Gara, 18379576, thomas.ogara@ucdconnect.ie
 */

import java.util.Scanner;

/**
 * This is the main driver program for Practical 1
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("This simple program aims to display the result of multiplying two numbers using the Russian Peasant Algorithm");
        String line = "";
        while(true){
            long a;
            long b;
            System.out.println("Please input the first integer");
            // Attempt to read console input and stall while allowing user entry
            // If anything other than a whole number is entered, quit
            if(sc.hasNextLong()) a = sc.nextLong();
            else return;

            System.out.println("Please input the second integer");
            // Attempt to read console input and stall while allowing user entry
            // If anything other than a whole number is entered, quit
            if(sc.hasNextLong()) b = sc.nextLong();
            else return;

            // Output the result of applying the russian peasant's algorithm to the provided arguments
            long start = System.nanoTime();
            long result = RussianPeasant.russianPeasantAlgorithm(a, b);
            long elapsed = System.nanoTime() - start;
            System.out.println(String.format("\nUsing the russian peasant's algorithm, %d * %d  was calculated as %d in %d nanoseconds\n", a, b, result, elapsed));

            // Prompt the user to identify if they wish to proceed
            System.out.println("Would you like to continue running the Practical 1 demo program?");
            System.out.println("If yes, enter 'Y'. Else, enter 'N'");
            while(!sc.hasNext("[nNyY]")){
                System.out.println("Sorry, that input wasn't recognised");
                System.out.println("Would you like to continue running the Practical 1 demo program?");
                System.out.println("If yes, enter 'Y'. Else, enter 'N'");
                sc.next(); // consume whatever didnt match the pattern
            }
            if(sc.next().matches("[Nn]")) return;
        }
    }
}
