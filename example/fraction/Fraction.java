/**
 * Programmer: Sean Yang
 * Program Name: Fraction
 * Description: Implements fractions using OOP paradigms
 * Date: 31/03/2025
 */

public class Fraction {
    private int num;
    private int denum;

    /**
     * gcd - returns the greatest common denominator of two numbers
     * 
     * @param a - the first number
     * @param b - the second number
     * @return the greatest common denominator
     */
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return (gcd(b, a % b));
        }
    }

    /**
     * lcm - returns the lowest common multiple of two numbers
     * 
     * @param a - the first number
     * @param b - the second number
     * @return the lowest common multiple
     */
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * reduce - simplifies the fraction
     */
    private void reduce() {
        int gcd = gcd(Math.abs(num), denum);
        num = num / gcd;
        denum = denum / gcd;
    }

    /**
     * magnitude - returns the absolute magnitude of the fraction
     * 
     * @return the magnitude as a positive double
     */
    public double magnitude() {
        return Math.abs((double) num / denum);
    }

    /**
     * decimal - returns the double-precision floating point representaiton of the
     * fraction
     * 
     * @return
     */
    public double decimal() {
        return (double) num / denum;
    }

    /**
     * Fraction - constructor method for the Fraction class
     * 
     * @param num   - the numerator
     * @param denum - the denominator
     */
    public Fraction(int num, int denum) {
        this.num = Math.abs(num);
        this.denum = Math.abs(denum);

        if (denum == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }

        boolean sgn = !((num < 0) ^ (denum < 0));
        if (!sgn) {
            this.num *= -1;
        }

        reduce();
    }

    /**
     * toString - returns the string representation of a fraction
     * 
     * @return the string representation
     */
    public String toString() {
        return "" + num + "/" + denum;
    }

    /**
     * add - adds two fractions
     * 
     * @param other the fraction to add
     */
    public void add(Fraction other) {
        int lcm = lcm(denum, other.denum);
        denum = lcm;
        num = num * (lcm / denum) + other.num * (lcm / other.denum);
        reduce();
    }

    /**
     * subtract - subtracts two fractions
     * 
     * @param other the fraction to subtract
     */
    public void subtract(Fraction other) {
        add(new Fraction(other.num * -1, other.denum));
        reduce();
    }

    /**
     * multiply - multiplies two fractions
     * 
     * @param other the fraction to multiply by
     */
    public void multiply(Fraction other) {
        denum = denum * other.denum;
        num = num * other.num;
        reduce();
    }

    /**
     * reciprocal - returns the reciprocal of a fraction
     * 
     * @param frac the fraction to find the reciprocal of
     * @return a new Fraction object, the reciprocal
     */
    public static Fraction reciprocal(Fraction frac) {
        return new Fraction(frac.denum, frac.num);
    }

    /**
     * divide - returns the quotient of two fractions
     * 
     * @param other the fraction to divide by
     */
    public void divide(Fraction other) {
        multiply(reciprocal(other));
        reduce();
    }

    /**
     * equals - returns whether two fractions are equal
     * 
     * @param other the fraction to compare against
     * @return whether the fractions are equal
     */
    public boolean equals(Fraction other) {
        if (num == other.num && denum == other.num) {
            return true;
        }
        return false;
    }

    /**
     * compareTo - compares this fraction to another fraction
     * 
     * @param other - the fraction to compare to
     * @return a positive integer if this fraction is greater, a negative integer if
     *         the other fraction is greater, or 0 if both are equal
     */
    public int compareTo(Fraction other) {
        if (equals(other)) {
            return 0;
        }
        return (int) Math.ceil(decimal() - other.decimal());
    }

    /**
     * larger - returns the larger of two fractions
     * 
     * @param other - the other fraction
     * @return the larger of the two fractions
     */
    public Fraction larger(Fraction other) {
        if (magnitude() > other.magnitude()) {
            return this;
        }
        return other;
    }

    /**
     * smaller - returns the smaller of two fractions
     * 
     * @param other - the other fraction
     * @return the smaller of the two fractions
     */
    public Fraction smaller(Fraction other) {
        if (magnitude() < other.magnitude()) {
            return this;
        }
        return other;
    }

    /**
     * clone - creates an identical copy of this fraction
     * 
     * @return a new identical Fraction object
     */
    public Fraction clone() {
        return new Fraction(num, denum);
    }

    /**
     * product - multiplies two fractions
     * 
     * @param a - the first fraction
     * @param b - the second fraction
     * @return the product
     */
    public static Fraction product(Fraction a, Fraction b) {
        return new Fraction(a.num * b.num, a.denum * b.denum);
    }

    /**
     * product - finds the sum of two fractions
     * 
     * @param a - the first fraction
     * @param b - the second fraction
     * @return the product
     */
    public static Fraction sum(Fraction a, Fraction b) {
        int lcm = lcm(a.denum, b.denum);
        int denum = lcm;
        int num = a.num * (lcm / denum) + b.num * (lcm / b.denum);
        return new Fraction(num, denum);
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 2);
        Fraction f2 = new Fraction(2, 3);

        f1.add(f2);

        System.out.println(f1);

        System.out.println(f1.decimal());
        System.out.println(f2.decimal());

        f1.subtract(f2);

        System.out.println(f1.decimal());

        f2 = new Fraction(1, 2);

        f1.subtract(f2);

        System.out.println(f1);

        Fraction f3 = new Fraction(3, 2);

        System.out.println(f3.compareTo(f1));

        f3.divide(new Fraction(3, 10));

        System.out.println(f3);

        System.out.println(Fraction.product(f2, f3));
    }
}
