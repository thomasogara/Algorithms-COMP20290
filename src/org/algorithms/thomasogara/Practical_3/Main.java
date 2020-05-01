package org.algorithms.thomasogara.Practical_3;

import java.util.Scanner;

/**
 * @author: Thomas O'Gara, 18379576, thomas.ogara@ucdconnect.ie
 */

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Practical 3 driver program!");
        System.out.println("Would you like to test:");
        System.out.println("\ta: Fibonacci (iterative vs recursive)");
        System.out.println("\tb: Towers of Hanoi");
        System.out.println("Please input a, or b below:");
        while(!sc.hasNext("a|b")){
            System.out.println("Sorry, that input wasn't recognised.");
            System.out.println("Would you like to test:");
            System.out.println("\ta: Fibonacci (iterative vs recursive)");
            System.out.println("\tb: Towers of Hanoi");
            System.out.println("Please input a, or b below:");
            sc.next(); // consume non-matching input
        }
        switch (sc.next()) {
            case "a":
                Fibonacci.main(null);
                break;
            case "b":
                System.out.println("How many disks would you like to test for?");
                while(!sc.hasNext("\\d+")){
                    System.out.println("Sorry, that input wasn't recognised.");
                    System.out.println("How many disks would you like to test for?");
                    sc.next();
                }
                Hanoi.main(new String[] {sc.next(), "source", "auxilliary", "destination"});
        }
    }
}
