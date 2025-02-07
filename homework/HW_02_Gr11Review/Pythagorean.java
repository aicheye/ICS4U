/*
 Programmer: Sean Yang
 Program Name: Pythagorean
 Date: 04/02/2025
 Description: Finds all pythagorean triples whose largest member is less than or equal to that integer
 */

import java.util.*;

public class Pythagorean {
    public static void main(String[] args) {
        // initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        int max;

        // take input
        System.out.print("Enter the largest number you want to check until: ");
        max = sc.nextInt();

        // nest for loop to check for triples
        System.out.println("Pythagorean triples:");

        // c must be at least 5 (the first pythagorean triple is 3, 4, 5)
        for (int c=5; c<=max; c++) {
            // a must be at least 2 (there are no consecutive square numbers)
            for (int a=2; a<=max; a++) {
                // based on the basic triangle inequality, a + b > c
                // thus, b cannot be smaller than c - a + 1 (b is an integer)
                // b also cannot = a since there are no isosceles right triangles.
                for (int b=c-a+1; b<a; b++) {
                    if (a*a + b*b == c*c) {
                        // output the triple
                        System.out.printf("(%d, %d, %d)\n", b, a, c);
                        break; // skip checking other values of b
                    }
                }
            }
        }

        // close scanner
        sc.close();
    }
}
