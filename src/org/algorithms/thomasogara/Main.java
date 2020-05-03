package org.algorithms.thomasogara;

import java.util.Scanner;

/**
 * @author: Thomas O'Gara, 18379576, thomas.ogara@ucdconnect.ie
 */

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello and welcome to my algorithms portfolio!");
        System.out.println("The objective of this program is to allow the user to make use of the algorithms written during the practical sessions of the algorithms COMP20290 module.");
        boolean continuing = true;

        while(continuing){
            System.out.println("Which Practical would you like to inspect?");
            System.out.print("PLease enter a number between 1 and 8 to execute the ");
            System.out.print("code associated with a given Practical session. Practical 9 was omitted as it involved executing ");
            System.out.println("provided code via the command line, and emulating this via a driver program is not accomplishable.");
            String line = sc.next();
            while (!line.matches("[1-8]]")) {
                System.out.println("Unfortunately, that is not a valid Practical session number, please try again");
                System.out.print("PLease enter a number between 1 and 8 to execute the ");
                System.out.print("code associated with a given Practical session. Practical 9 was omitted as it involved executing ");
                System.out.println("provided code via the command line, and emulating this via a driver program isn't really sensible.");
                line = sc.next();
            }
            int practicalNumber = Integer.parseInt(line);
            switch (practicalNumber) {
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
                    break;
                case 3:
                    org.algorithms.thomasogara.Practical_3.Main.main(null);
                    break;
                case 4:
                    org.algorithms.thomasogara.Practical_4.Main.main(null);
                    break;
                case 5:
                    org.algorithms.thomasogara.Practical_5.Sort.main(null);
                    break;
                case 6:
                    org.algorithms.thomasogara.Practical_6.Sort.main(null);
                    break;
                case 7:
                    org.algorithms.thomasogara.Practical_7.Main.main(null);
                    break;
                case 8:
                    org.algorithms.thomasogara.Practical_8.Trie.main(null);
                    break;
                default:
                    System.out.println("Unfortunately that input is not recognised.\n");
            }
            System.out.println("Would you like to continue testing the Practical demos?");
            System.out.println("If yes, enter 'Y'. Else, enter 'N'");
            while(!sc.hasNext("[ynYN]")){
                System.out.println("Sorry, that input wasn't recognised.\n");
                System.out.println("Would you like to continue testing the Practical demos?");
                System.out.println("If yes, enter 'Y'. Else, enter 'N'");
                sc.next(); // consume the non-matching input
            }
            if(sc.next().matches("[nN]]")) continuing = false;
        };
    }
}
