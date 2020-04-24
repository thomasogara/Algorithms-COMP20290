package org.algorithms.thomasogara.Practical_2;

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
        System.out.println("NOTICE: The running time for ThreeSumA on inputs > 2,000 items is measured in tens of minutes");
        System.out.println("I'd recommend simply quitting once the program starts processing 4Kints.txt");
        for(String arg : args){
            run(arg);
        }
    }
}
