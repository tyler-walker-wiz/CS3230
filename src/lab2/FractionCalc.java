package lab2;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FractionCalc {
    static String regex =
            "(-?[0-9]+)[ \t]*/[ \t]*(-?[0-9]+)[ \t]*([+-/\\*])[ \t]*(-?[0-9]+)[ \t]*/[ \t]*(-?[0-9]+)";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fStr;
        if (args.length != 0) {
            fStr = String.join(" ", args);

        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter input in the form: [-]n1 / [-]d1 op [-]n2 / [-]d2:");
            fStr = scanner.nextLine();
        }
        if (fStr == null) {
            System.err.println("No input entered");
            System.exit(1);
        }

        fStr = fStr.trim();

        if (fStr.matches(regex))
            System.out.println("Match:    " + fStr);
        else
            System.out.println("NO match: " + fStr);

        int denom1, denom2, numer1, numer2;
        String operator;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fStr);
        if (!matcher.matches()) {
            System.out.println("Incorrect Format");
            return;
        }
        try {
            numer1 = Integer.parseInt(matcher.group(1));
            denom1 = Integer.parseInt(matcher.group(2));
            operator = matcher.group(3);
            numer2 = Integer.parseInt(matcher.group(4));
            denom2 = Integer.parseInt(matcher.group(5));
        } catch (Exception e) {
            System.out.println("Incorrect format");
            throw e;
        }

        //StringTokenizer tokenizer = new StringTokenizer(fStr);

//        if (tokenizer.countTokens() != 5) {
//            System.out.println("Incorrect format");
//            return;
//        }

//        try {
//            denom1 = Integer.parseInt(tokenizer.nextToken());
//            denom2 = Integer.parseInt(tokenizer.nextToken());
//            numer1 = Integer.parseInt(tokenizer.nextToken());
//            numer2 = Integer.parseInt(tokenizer.nextToken());
//            operator = tokenizer.nextToken();
//        }
//        catch(Exception e){
//            System.out.println("Incorrect format");
//            throw e;
//        }

        // Execute logic
        Fraction fractionLeft = new Fraction(numer1, denom1);
        Fraction fractionRight = new Fraction(numer2, denom2);
        Fraction result;

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

        System.out.println("Calculation result: " + result.toString());

    }
}
