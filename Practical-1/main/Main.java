package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("This simple program aims to display the result of multiplying two numbers using the Russian Peasant Algorithm");
        System.out.println("If you would like to exit, simply use the EOF control sequence on your os.");
        System.out.println("Linux:   Ctrl+D");
        System.out.println("Mac  :   Cmd+D");
        System.out.println("Windows: Ctrl+Z\n");
        String line = "";
        while(true){
            System.out.println("Please input the first integer");
            long a = sc.nextLong();
            System.out.println("Please input the second integer");
            long b = sc.nextLong();
            System.out.println(String.format("%d * %d  = %d\n", a, b, RussianPeasant.russianPeasantAlgorithm(a, b)));
            System.out.println("If you would like to exit, simply use the EOF control sequence on your os.");
            System.out.println("Linux:   Ctrl+D");
            System.out.println("Mac  :   Cmd+D");
            System.out.println("Windows: Ctrl+X\n");
        }
        // I have never in my life felt the need to use a do-while loop
        // yet here I am, using one
    }
}
