
/**
 * Programmer: Sean Yang
 * Program: BinarySearchDescending
 * Date: 04/03/2025
 * Description: Performs binary search on a descending array
 */

public class BinarySearchDescending {

    /**
     * binarySearch searches an array sorted in descending order
     * 
     * @param array  the array to search
     * @param target the value to search for
     */
    public static int binarySearch(int[] array, int target) {
        // declare variables
        int lo = 0;
        int hi = array.length - 1;
        int idx = -1;

        while (lo <= hi && idx == -1) {
            int mid = (lo + hi) / 2;

            // compare mid to target and split list as required
            if (array[mid] == target) {
                idx = mid;
            } else if (array[mid] > target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        // test array
        int[] myNums = {
                13,
                9,
                5,
                3,
                2,
                0
        };

        // test binary search
        System.out.println("Finding 4: " + binarySearch(myNums, 4));
        System.out.println("Finding 3: " + binarySearch(myNums, 3));
        System.out.println("Finding -5: " + binarySearch(myNums, -5));
        System.out.println("Finding 13: " + binarySearch(myNums, 13));
    }
}
