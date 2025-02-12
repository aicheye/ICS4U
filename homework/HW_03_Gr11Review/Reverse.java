/*
    Programmer: Sean Yang
    Program Name: Reverse
    Date: 07/02/2025
    Description: Reverse an array of size 14 using two methods
*/

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        // declare constants
        final int SIZE = 14;

        // declare scanner and variables
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[SIZE];
        int[] rev = new int[SIZE];
        int temp;

        // take user input
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Enter an integer to add to the array: ");
            arr[i] = sc.nextInt();
        }

        // reverse arrays using the second
        for (int i = 0; i < SIZE; i++) {
            rev[i] = arr[SIZE - 1 - i];
        }

        // output the reversed array
        System.out.println("Reversed array: ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(rev[i] + " ");
        }
        System.out.println();

        // reverse arrays without using a second
        for (int i = 0; i < SIZE / 2; i++) {
            temp = arr[i];
            arr[i] = arr[SIZE - 1 - i];
            arr[SIZE - 1 - i] = temp;
        }

        // output the reversed array
        System.out.println("Reversed array only using 1 array: ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // close scanner
        sc.close();
    }
}
