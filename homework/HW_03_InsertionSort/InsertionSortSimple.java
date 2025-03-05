
/**
 * Programmer: Sean Yang
 * Program Name: InsertionSortSimple
 * Date: 05/03/2025
 * Description: Implements the InsertionSort algorithm
 */

public class InsertionSortSimple {

    /**
     * insertionSort sorts an array of integers in ascending order
     * 
     * @param arr the array to sort
     */
    public static void insertionSort(int[] arr) {
        // loop over each element in the array
        for (int i = 0; i < arr.length; i++) {
            // get current value
            int curr = arr[i];
            // set blank index to i
            int blank = i;

            // loop until we find a suitable position for curr
            while (blank > 0 && curr < arr[blank - 1]) {
                // move the blank index one left
                arr[blank] = arr[blank - 1];
                blank--;
            }

            // put the current value in the blank index
            arr[blank] = curr;
        }
    }

    public static void main(String[] args) {
        // test array
        int[] arr = {
                3,
                4,
                5,
                1,
                2,
                3,
                99,
                10,
                4,
                0
        };

        // sort
        insertionSort(arr);

        // output array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
