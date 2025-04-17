
/**
 * Programmer: Sean Yang
 * Program Name: InsertionSortPlanets
 * Date: 03/05/2025
 * Description: Sorts an array with the names of planets alphabetically
 */

public class InsertionSortPlanets {

    /**
     * printArray prints an array to standard output
     * 
     * @param arr the array to print
     */
    public static void printArray(String[] arr) {
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    /**
     * insertionSort sorts an array of strings alphabetically
     * 
     * @param arr the array to sort
     */
    public static void insertionSort(String[] arr) {
        // loop over each element
        for (int i = 0; i < arr.length; i++) {
            // set variables
            String curr = arr[i];
            int blank = i;

            // loop until we find a suitable place for curr
            while (blank > 0 && curr.compareTo(arr[blank - 1]) < 0) {
                arr[blank] = arr[blank - 1];
                blank--;
            }

            // put curr in blank
            arr[blank] = curr;

            // output array
            printArray(arr);
        }
    }

    public static void main(String[] args) {
        String[] planets = {
                "Mercury",
                "Venus",
                "Earth",
                "Mars",
                "Jupiter",
                "Saturn",
                "Uranus",
                "Neptune",
                "Pluto"
        };

        // sort
        insertionSort(planets);
    }
}
