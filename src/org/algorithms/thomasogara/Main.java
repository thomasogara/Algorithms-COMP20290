package org.algorithms.thomasogara;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello and welcome to my algorithms portfolio!");
        System.out.println("The objective of this program is to allow the user to make use of the algorithms written during the practical sessions of the algorithms COMP20290 module.");
        System.out.println("Which Practical would you like to inspect?");
        String line = sc.next();
        while(!line.matches("\\d{1,2}")){
            System.out.println("Unfortunately, that is not a valid line number, please try again");
            line = sc.next();
        }
        int practicalNumber = Integer.parseInt(line);
        switch (practicalNumber){
            case 1:
                org.algorithms.thomasogara.Practical_1.Main.main(null);
                break;
            case 2:
                String[] filenames = {
                        "assets/Practical_2/8ints.txt", "assets/Practical_2/1Kints.txt",
                        "assets/Practical_2/2Kints.txt", "assets/Practical_2/4Kints.txt",
                        "assets/Practical_2/8Kints.txt", "assets/Practical_2/16Kints.txt",
                        "assets/Practical_2/32Kints.txt"
                };
                org.algorithms.thomasogara.Practical_2.Main.main(filenames);
        }
    }
}
