/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author w01266833
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(string s in new String()){
        
        }
       String o1 = "Hello";
       String o2 = "Hel";
       o2 += "lo";
       System.out.println(o1.equals(o2));
       System.out.println(args.length);
       System.out.println(args[0]);
       if (args.length == 0)		// version 1
        {
            System.out.println("USAGE: java Palindrome <name>");
            System.exit(1);
	}
        String name = args[1];
        if (name == null)
        {
            System.err.println("No name entered");
            System.exit(1);
        }

        System.out.print("+");
        for(int i = 0; i < name.length(); i++)
            System.out.print("-");
        System.out.println("+");

        System.out.println("|" + name + "|");

        System.out.print("+");
        for(int i = 0; i < name.length(); i++)
            System.out.print("-");
        System.out.println("+");
    }
    
}
