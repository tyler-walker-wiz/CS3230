/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Scanner;

/**
 * @author w01266833
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name;
        if (args.length != 0) {
            name = String.join(" ", args);

        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a potential palindrome:");
            name = scanner.nextLine();
        }
        if (name == null) {
            System.err.println("No name entered");
            System.exit(1);
        }
        //Replace invalid characters
        String parsed = name.replaceAll("(\\\\w)(\\\\s+)([\\\\.,])","");
        StringBuilder sb = new StringBuilder(parsed);
        System.out.println(sb.toString());
        //Create reversed copy to compare
        StringBuilder sbCopy = new StringBuilder(parsed).reverse();
        System.out.println(sbCopy.toString());
        boolean isPalindrome = true;
        //Loop through characters
        for(int i = 0; i < sb.length(); i++){
            //Check if character is equal at same position (front or back)
            if(sb.charAt(i) != sbCopy.charAt(i))
                isPalindrome = false;
        }
        //Print result
        System.out.println(isPalindrome);
    }

}
