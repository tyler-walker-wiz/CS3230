/*
 * Author: Tyler Walker
 * Assignment: Lab2
 * Course: CS 3230
 */

//package lab2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FractionCalc {
    static String regex =
            "(-?[0-9]+)[ \t]*/[ \t]*(-?[0-9]+)[ \t]*([+-/\\*])[ \t]*(-?[0-9]+)[ \t]*/[ \t]*(-?[0-9]+)";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fracInput;
        if (args.length != 0) {
            fracInput = String.join(" ", args);

        } else {
            //Get input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter input in the form [-]n1 / [-]d1 op [-]n2 / [-]d2:");
            fracInput = scanner.nextLine();
        }
        if (fracInput == null) {
            System.err.println("No input entered");
            System.exit(1);
        }

        //Trim whitespace from edges
        fracInput = fracInput.trim();

        //Check for a match
        if (fracInput.matches(regex))
            System.out.println("Match:    " + fracInput);
        else
            System.out.println("NO match: " + fracInput);

        int denLeft, denRight, numLeft, numRight;
        String operator;
        //Match regex string
        Pattern pattern = Pattern.compile(regex);
        //Get matches
        Matcher matcher = pattern.matcher(fracInput);
        if (!matcher.matches()) {
            System.out.println("Incorrect Format");
            return;
        }
        try {
            //Get each fraction piece and place into variable
            numLeft = Integer.parseInt(matcher.group(1));
            denLeft = Integer.parseInt(matcher.group(2));
            operator = matcher.group(3);
            numRight = Integer.parseInt(matcher.group(4));
            denRight = Integer.parseInt(matcher.group(5));
        } catch (Exception e) {
            System.out.println("Incorrect format");
            throw e;
        }

        // Execute logic
        Fraction fractionLeft = new Fraction(numLeft, denLeft);
        Fraction fractionRight = new Fraction(numRight, denRight);
        Fraction result;

        //Decide which operation to execute based on operator
        switch (operator) {
            case "+":
                result = fractionLeft.add(fractionRight);
                break;
            case "-":
                result = fractionLeft.sub(fractionRight);
                break;
            case "*":
                result = fractionLeft.mult(fractionRight);
                break;
            case "/":
                result = fractionLeft.div(fractionRight);
                break;
            default:
                throw new IllegalArgumentException("Operator is not of the valid values.");
        }

        //Print result
        System.out.println("Calculation result: " + result);


//        Tests
//        System.out.println(fractionLeft.equals(fractionRight));
//        System.out.println(fractionLeft.equals(2));
//        System.out.println(fractionLeft.equals("4"));
    }
}
