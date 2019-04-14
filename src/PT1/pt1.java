/*
 * Author: Tyler Walker
 * Programming Test 1
 * Course: CS 3230
 */

package PT1;

public class pt1 {
    public static void main(String[] args){
        Password p1 = new Password("yolo");
        Password p2 = new Password("yolo");
        if(p1.equals(p2))
            System.out.println("Passwords are equal.");
        else
            System.out.println("Passwords are NOT equal.");

        Lock l1 = new Lock();
        Lock l2 = new Lock();
        if(l1.equals(l2))
            System.out.println("Locks are equal.");
        else
            System.out.println("Locks are NOT equal.");

        Combination c1 = new Combination(1,2,2);
        Combination c2 = new Combination(1,2,3);
        if(c1.equals(c2))
            System.out.println("Combinations are equal.");
        else
            System.out.println("Combinations are NOT equal.");

        Double d1 = new Double(234, "hello");
        Double d2 = new Double(234, "hello");
        if(d1.equals(d2))
            System.out.println("Doubles are equal.");
        else
            System.out.println("Doubles are NOT equal.");

    }
}
