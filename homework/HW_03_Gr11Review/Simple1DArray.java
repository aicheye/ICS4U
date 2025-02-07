/*
 Programmer: Sean Yang
 Program Name: Simple1DArray
 Date: 07/02/2025
 Description: Performs various operations on arrays
 */

import java.util.*;

public class Simple1DArray {
    public static void main(String[] args) {
        // initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        int[] array;
        int n;
        int temp;
        int sampleSum;

        // take in n
        System.out.print("Enter an integer n: ");
        n = sc.nextInt();

        // initialize array
        array = new int[n];

        // enter n integers
        for (int i = 0; i<n; i++) {
            System.out.print("Enter an integer to add to your array: ");
            array[i] = sc.nextInt();
        }

        // switch the values at either end of the array
        temp = array[0];
        array[0] = array[n-1];
        array[n-1] = temp;

        // make elements positive
        for (int i=0; i<n; i++) {
            if (array[i] < 0 ) array[i] = -array[i];
        }

        // sum all the values of the array
        sampleSum = 0;
        for (int i=0; i<n; i++) {
            sampleSum += array[i];
        }

        // output the even numbers in the array
        System.out.println("Even numbers in the array: ");
        for (int i=0; i<n; i++) {
            if (array[i] % 2 == 0) System.out.println(array[i]);
        }
    }
}