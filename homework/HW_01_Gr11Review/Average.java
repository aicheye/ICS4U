/*
 Programmer: Sean Yang
 Program Name: Average
 Date: 04/02/2025
 Description: Calculates the average of three floats
 */

import java.util.*;

public class Average {
    public static void main(String[] args) {
        // initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        double f1, f2, f3;
        double average;

        // read 3 floats
        System.out.print("Enter the first number: ");
        f1 = sc.nextDouble();
        System.out.print("Enter the second number: ");
        f2 = sc.nextDouble();
        System.out.print("Enter the third number: ");
        f3 = sc.nextDouble();

        // calculate the average
        average = (f1 + f2 + f3) / 3;

        // output
        System.out.println("The average of your three numbers is " + average);

        // close scanner
        sc.close();
    }
}
