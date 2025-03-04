
/**
 * Programmer: Sean Yang
 * Program Name: PartialSort
 * Date: 04/03/2025
 * Description: Partially sorts an array using insertion sort
 */

import java.util.Scanner;

public class PartialSort {
    public static void main(String[] args) {
        // declare scanner
        Scanner sc = new Scanner(System.in);
        final int SIZE = sc.nextInt();
        int[] array = new int[SIZE];

        // take user input for the array
        for (int i=0; i<SIZE; i++) {
            array[i] = sc.nextInt();
        }

        // sort using insertion sort
        // lower bound increases with each loop
        for (int lo = 0; lo<=SIZE / 2; lo++) {
            int minIndex = lo;
            // loop from lower bound to last element of array
            for (int i=lo; i<SIZE; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            // swap minIndex and lo
            int temp = array[lo];
            array[lo] = array[minIndex];
            array[minIndex] = temp;
        }

        // find the median
        int median;
        if (SIZE % 2 == 0) {
            median = (array[SIZE / 2] + array[SIZE / 2 - 1]) / 2;
        }
        else {
            median = (array[SIZE / 2]);
        }

        // output median
        System.out.println(median);
    }
}
