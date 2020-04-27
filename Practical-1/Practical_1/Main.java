package org.algorithms.thomasogara.Practical_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("This simple program aims to display the result of multiplying two numbers using the Russian Peasant Algorithm");
        String line = "";
        while(true){
            long a;
            long b;
            System.out.println("Please input the first integer");
            if(sc.hasNextLong()) a = sc.nextLong();
            else return;
            System.out.println("Please input the second integer");
            if(sc.hasNextLong()) b = sc.nextLong();
            else return;
            System.out.println(String.format("\n%d * %d  = %d\n", a, b, RussianPeasant.russianPeasantAlgorithm(a, b)));
            System.out.println("Would you like to continue running the Practical 1 demo program?");
            System.out.println("If yes, enter 'Y'. Else, enter 'N'");
            while(!sc.hasNext("Y|N")){
                System.out.println("Sorry, that input wasn't recognised");
                System.out.println("Would you like to continue running the Practical 1 demo program?");
                System.out.println("If yes, enter 'Y'. Else, enter 'N'");
                sc.next(); // consume whatever didnt match the pattern
            }
            if(sc.next().equals("N")) return;
        }
    }
}
