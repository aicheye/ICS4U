/**
 * Programmer: Sean Yang
 * Program Name: Search
 * Date: 26/02/2025
 * Description: Various search algorithms and main method to test
 */

import java.util.Scanner;

public class Search {
    /**
     * sequentialSearch searches an array of integers linearly
     * 
     * @param array the array to search
     * @param item  the item to find
     * @return the index of the item within the array (-1 if it doesn't exist)
     */
    public static int sequentialSearch(int[] array, int item) {
        // set index
        int index = -1;

        // loop over every element while still searching and check if it matches
        for (int i = 0; i < array.length && index == -1; i++) {
            if (array[i] == item) {
                index = i;
            }
        }

        // return -1 if no index found
        return index;
    }

    /**
     * binarySearch searches an array of integers in O(logN) time
     * 
     * @param array the array to search (must be sorted in non-decreasing order)
     * @param item  the itme to find
     * @return the index of the item within the array (-1 if it doesn't exist)
     */
    public static int binarySearch(int[] array, int item) {
        // set variables
        int index = -1;
        int hi = array.length - 1;
        int lo = 0;
        int mid;

        // loop while the size of the array slice is at least 1,
        // and we haven't found the item yet
        while (lo <= hi && index == -1) {
            // middle index (average of lo and hi)
            mid = (lo + hi) / 2;

            // check if the middle index is the item
            if (array[mid] == item) {
                index = mid;
            }

            // set hi to one below the mid if mid is greater than item
            else if (array[mid] > item) {
                hi = mid - 1;
            }

            // set lo to one above mid if mid is less than item
            else {
                lo = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        // initialize scanner
        Scanner sc = new Scanner(System.in);

        // test array
        int[] myArray = {
                1,
                2,
                3,
                4,
                5,
                5,
                10,
                21
        };

        // ask user for query
        System.out.print("Enter your query: ");
        int query = sc.nextInt();

        // find index (sequential search)
        int index = sequentialSearch(myArray, query);

        // check if index is valid
        if (index >= 0) {
            System.out.println("Found at index " + index);
        } else {
            System.out.println("Item not found.");
        }

        // find index (binary search)
        index = binarySearch(myArray, query);

        // check if index is valid
        if (index >= 0) {
            System.out.println("Found at index " + index);
        } else {
            System.out.println("Item not found.");
        }

        // close scanner
        sc.close();
    }
}
