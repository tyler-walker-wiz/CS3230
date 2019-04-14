/*
 * Author: Tyler Walker
 * Programming Test 1
 * Course: CS 3230
 */

package PT1;

public class Lock {
    public Lock(){}
    public boolean equals(Lock other) {
        try {
            return this.getClass().equals(other.getClass());
        } catch (NullPointerException e) {
            System.err.println("The equals method requires a non-null argument.");
            throw e;
        } catch (Throwable e) {
            System.err.println("Something went wrong. Please check that input is in the correct format.");
            throw e;
        }
    }
}

class Password extends Lock {
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public boolean equals(Password other) {
        try {
            return this.password.equals(other.password) && super.equals(other);
        } catch (NullPointerException e) {
            System.err.println("The equals method requires a non-null argument.");
            throw e;
        } catch (Throwable e) {
            System.err.println("Something went wrong. Please check that input is in the correct format.");
            throw e;
        }
    }
}

class Combination extends Lock {
    private int first;
    private int second;
    private int third;

    public Combination(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean equals(Combination other) {
        try {
            return this.first == other.first &&
                    this.second == other.second &&
                    this.third == other.third &&
                    super.equals(other);
        } catch (NullPointerException e) {
            System.err.println("The equals method requires a non-null argument.");
            throw e;
        } catch (Throwable e) {
            System.err.println("Something went wrong. Please check that input is in the correct format.");
            throw e;
        }
    }
}

class Double extends Password {
    private int pin;
    public Double(int pin, String password){
        super(password);
        this.pin = pin;
    }

    public boolean equals(Double other){
        try {
            return this.pin == other.pin && super.equals(other);
        } catch (NullPointerException e) {
            System.err.println("The equals method requires a non-null argument.");
            throw e;
        } catch (Throwable e) {
            System.err.println("Something went wrong. Please check that input is in the correct format.");
            throw e;
        }
    }
}

