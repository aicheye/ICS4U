
/**
 * Programmer: Sean Yang
 * Program Name: Sort
 * Date: 28/02/2025
 * Description: Various sorting algorithms and main method to test
 */

public class Sort {

    /**
     * insertionSort sorts an array using the insertion sort algorithm
     * 
     * @param array the array to sort
     */
    public static void insertionSort(int[] array) {
        // loop over each item
        for (int i = 0; i < array.length; i++) {
            // set the current item to compare
            int curr = array[i];
            int pos = i;

            // continue until we find a suitable place for curr
            while (pos > 0 && curr < array[pos - 1]) {
                // move the item one index right and decrement current position
                array[pos] = array[pos - 1];
                pos--;
            }

            // set the correct position to curr
            array[pos] = curr;
        }
    }

    /**
     * selectionSort sorts an array using the selection sort algorithm
     * 
     * @param array the array to sort
     */
    public static void selectionSort(int[] array) {
        // loop backwards (shrink from whole array to just 1 element)
        for (int lo = 0; lo < array.length; lo++) {
            // find the smallest value from remaining array and swap with lo
            int minIndex = lo;
            for (int i = lo; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }

            // swap maxIndex and lo
            int temp = array[minIndex];
            array[minIndex] = array[lo];
            array[lo] = temp;
        }
    }

    /**
     * bubbleSort sorts an array using the bubble sort algorithm
     * 
     * @param array the array to sort
     */
    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        // continue while swapping and shrink upper bound
        for (int hi = array.length - 1; hi >= 1 && !sorted; hi--) {
            // set sorted to true
            sorted = true;

            // loop from top to bottom
            for (int i = 0; i < hi; i++) {
                if (array[i] > array[i + 1]) {
                    // swap elements if they are in the wrong order
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    // set sorted to false
                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        // test arrays
        int[] myArray1 = {
                1,
                3,
                5,
                6,
                21,
                23,
                4,
                0
        };

        int[] myArray2 = {
                1,
                3,
                5,
                6,
                21,
                23,
                4,
                0
        };

        int[] myArray3 = {
                1,
                3,
                5,
                6,
                21,
                23,
                4,
                0
        };

        // sort
        insertionSort(myArray1);
        selectionSort(myArray2);
        bubbleSort(myArray3);

        // output arrays
        for (int i = 0; i < myArray1.length; i++) {
            System.out.print(myArray1[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < myArray2.length; i++) {
            System.out.print(myArray2[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < myArray3.length; i++) {
            System.out.print(myArray3[i] + " ");
        }
        System.out.println();
    }
}
