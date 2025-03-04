
/**
 * Programmer: Sean Yang
 * Program Name: SequentialSwap
 * Date: 04/03/2025
 * Description: Performs sequential search, swapping once the item is found
 */

import java.util.Scanner;

public class SequentialSwap {

    /**
     * sequentialSwap performs sequential search on an array, then swaps the item with the previous.
     *
     * @param array the array to search
     * @param target the item to search for
     */
    public static int sequentialSwap(int[] array, int target) {
        // set variables
        int index = -1;

        for (int i=0; i<array.length && index == -1; i++) {
            if (array[i] == target) {
                // target has been located
                index = i;

                // swap with previous
                if (i > 0) {
                    array[i] = array[i] + array[i-1];
                    array[i-1] = array[i] - array[i-1];
                    array[i] = array[i] - array[i-1];
                }
            }
        }

        // return index
        return index;
    }

    public static void main(String[] args) {
        // declare variables
        Scanner sc = new Scanner(System.in);
        final int END = 0;

        // user input for length of array
        System.out.print("Enter array length: ");
        final int SIZE = sc.nextInt();
        int[] array = new int[SIZE];

        // input into array
        for (int i=0; i<SIZE; i++) {
            System.out.print("Enter element at index " + i + ": ");
            array[i] = sc.nextInt();
        }

        System.out.print("\nEnter an element to find (or 0 to quit): ");
        int target = sc.nextInt();
        while (target != END) {
            int idx = sequentialSwap(array, target);

            // output index
            if (idx != -1) {
                System.out.println("\nFound at index " + idx);
            }
            else {
                System.out.println("\nElement not found");
            }

            // output array
            System.out.print("New array: { " + array[0]);
            for (int i=1; i<SIZE; i++) {
                System.out.print(" " + array[i]);
            }
            System.out.println(" }");

            System.out.print("\nEnter an element to find (or 0 to quit): ");
            target = sc.nextInt();
        }
    }
}
