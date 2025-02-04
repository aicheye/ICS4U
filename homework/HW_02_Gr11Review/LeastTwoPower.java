/*
 Programmer: Sean Yang
 Program Name: LeastTwoPower
 Date: 04/02/2025
 Description: Outputs the smallest power of two which is greater than or equal to the number that is read
 */

import java.util.*;

public class LeastTwoPower {
    public static void main(String[] args) {
        // initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        int num;
        int pow = 1;
        int exp = 0;

        // take user input
        System.out.print("Enter a number: ");
        num = sc.nextInt();

        // loop until the number is at least as large as num
        while (pow < num) {
            pow *= 2;
            exp++;
        }

        // output the answer
        System.out.printf("%d = 2^%d is the smallest power of two greater than %d\n", pow, exp, num);
    }
}
