package org.algorithms.thomasogara.Practical_9;

public class RunLengthString {
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Must provide at least one argument");
            return;
        }

        String input = args[0];
        int run = 0;
        char oldChar = input.charAt(0);
        for(int i = 0; i < input.length(); i++){
            char nextChar = input.charAt(i);
            if(oldChar != nextChar){
                System.out.print(String.format("%c%d", oldChar, run));
                run = 1;
                oldChar = nextChar;
            }
            else{
                run++;
                if(i == input.length() - 1){
                    System.out.print(String.format("%c%d", oldChar, run));
                }
            }
        }
    }
}
