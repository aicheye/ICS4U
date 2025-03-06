
/**
 * Programmer: Sean Yang
 * Program Name: RecursionHomework
 * Date: 03/06/2025
 * Description: Various recursive functions
 */

public class RecursionHomework {

    /**
     * gcd implements the Euclidian Algorithm to
     * find the GCD of two integers
     * 
     * @param m
     * @param n
     * @return the greatest common divisor
     */
    public static int gcd(int m, int n) {
        if (m == n) {
            return m;
        } else if (m > n) {
            return gcd(n, m - n);
        } else {
            return gcd(n, m);
        }
    }

    /**
     * square finds the square of a number recursively
     * 
     * @param N the number to square
     * @return the square
     */
    public static int square(int N) {
        if (N == 1) {
            return 1;
        }
        return square(N - 1) + 2 * N - 1;
    }

    /**
     * prime wrapper function to determine if a number is prime recursively
     * 
     * @param N the number to evaluate
     * @return true if it is prime, false if it is composite
     */
    public static boolean prime(int N) {
        return prime(N, N - 1);
    }

    /**
     * prime recursive function to determine if a number is prime
     * 
     * @param N the number
     * @param D the divisor to test
     * @return true if it is prime false if it is compostie
     */
    private static boolean prime(int N, int D) {
        if (D == 1) {
            return true;
        }
        if (N % D == 0) {
            return false;
        }
        return prime(N, D - 1);
    }

    /**
     * power recursively finds the power of a number
     * 
     * @param X the base
     * @param N the exponent
     * @return X to the power of N
     */
    public static int power(int X, int N) {
        if (N == 0) {
            return 1;
        }
        return X * power(X, N - 1);
    }

    public static void main(String[] args) {
        System.out.println(gcd(100, 30));
        System.out.println(gcd(9, 8));
        System.out.println(gcd(12932132, 2193723));
        System.out.println();

        System.out.println(square(1));
        System.out.println(square(13));
        System.out.println();

        System.out.println(prime(5));
        System.out.println(prime(13));
        System.out.println(prime(22));
        System.out.println();

        System.out.println(power(3, 2));
        System.out.println(power(1, 3));
        System.out.println(power(2, 10));
    }
}
