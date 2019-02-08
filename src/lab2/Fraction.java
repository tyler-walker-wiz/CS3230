/*
 * Author: Tyler Walker
 * Assignment: Lab2
 * Course: CS 3230
 */

//package lab2;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction(int numerator, int denominator) {
        //Reduce fraction
        int divisor = gcd(numerator, denominator);

        //Assign private variables
        this.numerator = numerator / divisor;
        this.denominator = denominator / divisor;

        //Make sure signs are correct
        if(this.numerator < 0 && this.denominator < 0){
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    //Method to add fractions and return a new, reduced fraction
    public Fraction add(Fraction right){
        if(this.denominator == right.denominator)
            return new Fraction(this.numerator + right.numerator, this.denominator);

        int resultDenom = this.denominator * right.denominator;
        int resultNumer1 = this.numerator * right.denominator;
        int resultNumer2 = right.numerator * this.denominator;
        int resultNumer = resultNumer1 + resultNumer2;

        return new Fraction(resultNumer, resultDenom);
    }

    //Method to subtract fractions and return a new, reduced fraction
    public Fraction sub(Fraction right){
        if(this.denominator == right.denominator)
            return new Fraction(this.numerator - right.numerator, this.denominator);

        int resultDenom = this.denominator * right.denominator;
        int resultNumer1 = this.numerator * right.denominator;
        int resultNumer2 = right.numerator * this.denominator;
        int resultNumer = resultNumer1 - resultNumer2;

        return new Fraction(resultNumer, resultDenom);
    }

    //Method to multiply fractions and return a new, reduced fraction
    public Fraction mult(Fraction right){
        int resultDenom = this.denominator * right.denominator;
        int resultNumer = this.numerator * right.numerator;

        return new Fraction(resultNumer, resultDenom);
    }

    //Method to divide fractions and return a new, reduced fraction
    public Fraction div(Fraction right){
        //Multiply by reciprocal
        return this.mult(new Fraction(right.denominator,right.numerator));
    }

    //String Override method for Fraction class
    @Override
    public String toString() {
        if(this.denominator == 1)
            return Integer.toString(this.numerator);
        if(this.denominator == -1)
            return "-" + this.numerator;
        return this.numerator + "/" + this.denominator;
    }

    //Equals Override method for Fraction class
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fraction &&
                this.denominator == ((Fraction) obj).denominator &&
                this.numerator == ((Fraction) obj).numerator;
    }

    //Euclid's Algorithm
    private int gcd(int u, int v) {
        u = (u < 0) ? -u : u;  // make u non-negative
        v = (v < 0) ? -v : v;  // make v non-negative
        while (u > 0) {
            if (u < v) {
                int t = u;   // swap u and v
                u = v;
                v = t;
            }
            u -= v;
        }
        return v;         // the GCD of u and v
    }
}
