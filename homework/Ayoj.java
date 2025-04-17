import java.util.Scanner;

public class Ayoj {

    /**
     * printArray prints an array to an input stream
     * 
     * @param array array to print
     */
    public static void printArray(int[] array) {
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

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

            // output array
            printArray(array);
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

            // output array
            printArray(array);
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

                    // output array
                    printArray(array);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N;
        N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // sort
        insertionSort(arr);
        // selectionSort(myArray2);
        // bubbleSort(myArray3);

        sc.close();
    }
}
