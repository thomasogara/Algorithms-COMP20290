package org.algorithms.thomasogara.Practical_3;

import java.util.ArrayList;
import java.lang.Math;

public class Fibonacci{
    public static int fibonacciIterative(int n){
        if(n <= 1) return 1;
        int fib = 1;
        int prevFib = 1;

        for(int i = 2; i < n; i++){
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }

        return fib;        
    }

	public static int fibonacciRecursive(int n){
		if(n == 0 || n == 1){
            return 1;
		}else{           
            return n + fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
		}
	}

	public static void main(String[] args){
        System.out.println("TESTING ITERATIVE");
        for(int i = 0; i < 50; i++){
            long start = System.nanoTime();
            int result = fibonacciIterative(i);
            long end = System.nanoTime() - start;
            System.out.println(String.format("%3d\t\t%d", i, end));
	    }
        System.out.println("TESTING RECURSIVE");
        for(int i = 0; i < 50; i++){
            long start = System.nanoTime();
            int result = fibonacciRecursive(i);
            long end = System.nanoTime() - start;
            System.out.println(String.format("%3d\t\t%d", i, end));
	    }
    }
}
