
/**
 * Programmer: Sean Yang
 * Program Name: BinarySearchNearestIndex
 * Date: 03/04/2025
 * Description: Binary search algorithm which returns the nearest index
 */

import java.util.Scanner;

public class BinarySearchNearestIndex {

    /**
     * binarySearch searches an array and returns the nearest index
     * 
     * @param array  the array to search
     * @param target the value to search for
     * @return the nearest index (if two indices are equidistant, the lowest of the
     *         two)
     */
    public static int binarySearch(int[] array, int target) {
        // declare variables
        int hi = array.length - 1;
        int lo = 0;
        int idx = -1;

        // binary search loop
        while (lo <= hi && idx == -1) {
            int mid = (lo + hi) / 2;

            // compare target to mid and split array as needed
            if (array[mid] == target) {
                idx = mid;
            } else if (array[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        // check if the element is not in the array
        if (idx == -1) {
            // if the upper bound is less than index 0, the target is smaller
            if (hi < 0) {
                idx = 0;
            }
            // if the lower bound is above the highest index, the target is larger
            else if (lo > array.length - 1) {
                idx = array.length - 1;
            }
            // otherwise, check which of the two indices the element is closest to
            else {
                if (Math.abs(array[lo] - target) < Math.abs(array[hi] - target)) {
                    idx = lo;
                } else {
                    idx = hi;
                }
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < Q; i++) {
            int q = sc.nextInt();
            System.out.println(binarySearch(arr, q));
        }

        sc.close();
    }
}
