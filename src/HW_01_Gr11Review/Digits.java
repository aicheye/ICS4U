/*
 Programmer: Sean Yang
 Program Name: Digits
 Date: 04/02/2025
 Description: Finds the sums of the digits of a 3-digit number
 */

import java.util.*;

public class Digits {
    public static void main(String[] args) {
        // initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        int num, sum;

        // read the number
        System.out.print("Enter a 3-digit number: ");
        num = sc.nextInt();

        // calculate the sum
        sum = num / 100 + num / 10 % 10 + num % 10;

        // output
        System.out.println("Your number is " + num);
        System.out.println("The sum of the digits of your number is " + sum);

        // close scanner
        sc.close();
    }
}
