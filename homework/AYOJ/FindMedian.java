
/**
 * Programmer: Sean Yang
 * Program Name: Find Median
 * Date: 04/03/2025
 * Description: Finds the median of an array
 */

import java.util.Scanner;

public class FindMedian {
    public static void main(String[] args) {
        // declare scanner
        Scanner sc = new Scanner(System.in);
        final int SIZE = sc.nextInt();
        final int K = sc.nextInt();
        int[] array = new int[SIZE];

        // take user input for the array
        for (int i=0; i<SIZE; i++) {
            array[i] = sc.nextInt();
        }

        // sort using insertion sort
        // upper bound decreases with each loop
        for (int hi = SIZE - 1; hi>=SIZE-K; hi--) {
            int maxIndex = hi;
            // loop from first element to upper bound
            for (int i = 0; i<=hi; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            // swap maxIndex and hi
            int temp = array[hi];
            array[hi] = array[maxIndex];
            array[maxIndex] = temp;
        }

        // output array
        for (int i=0; i<SIZE; i++) {
            System.out.println(array[i]);
        }

        // close scanner
        sc.close();
    }
}
