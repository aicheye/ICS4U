
/**
 * Programmer: Sean Yang
 * Program Name: BinarySearchString
 * Date: 04/03/2025
 * Description: Searches a string using binary search
 */

import java.util.Scanner;

public class BinarySearchString {

    /**
     * binarySearch binary search on an array of strings
     * 
     * @param array  the array to search
     * @param target the string to find
     * @return the index of the string (-1 if it doesn't exist)
     */
    public static int binarySearch(String[] array, String target) {
        // declare variables
        int lo = 0;
        int hi = array.length - 1;
        int idx = -1;

        // binary search loop
        while (lo <= hi && idx == -1) {
            int mid = (lo + hi) / 2;

            // check which side to use
            if (array[mid].equals(target)) {
                idx = mid;
            } else if (array[mid].compareTo(target) < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        // return answer
        return idx;
    }

    public static void main(String[] args) {
        // declare variables
        Scanner sc = new Scanner(System.in);
        String[] strings = {
                "aa",
                "ab",
                "abc",
                "abcc",
                "abcde",
                "z"
        };

        // user input
        System.out.print("Enter a string to search for: ");
        String target = sc.nextLine();

        // binary search
        int idx = binarySearch(strings, target);

        if (idx == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found at index " + idx);
        }
    }
}
