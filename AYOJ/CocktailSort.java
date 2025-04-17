import java.util.Scanner;

/**
 * Programmer: Sean Yang
 * Program Name: Sort
 * Date: 28/02/2025
 * Description: Various sorting algorithms and main method to test
 */

public class CocktailSort {

    public static void printArray(int[] array) {
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    /**
     * cocktailSort sorts an array in ascending order using the Cocktail Sort
     * Algorithm
     *
     * @param array the array to sort
     */
    public static void cocktailSort(int[] array) {
        // set variables
        boolean sorted = false;
        int lo = 0;
        int hi = array.length - 1;

        // loop until sorted
        while (!sorted && hi > lo) {
            sorted = true;

            // loop from left to right
            for (int i = lo; i <= hi - 1; i++) {
                // swap if in incorrect order
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;

                    printArray(array);
                }
            }

            // decrement upper bound
            hi--;

            // loop from right to left
            for (int i = hi; i >= lo + 1; i--) {
                // swap if in incorrect order
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    sorted = false;

                    printArray(array);
                }
            }

            // increment lower bound
            lo++;
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

        cocktailSort(arr);

        // close scanner
        sc.close();
    }
}
