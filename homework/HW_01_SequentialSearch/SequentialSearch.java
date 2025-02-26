
/*
 * Programmer: Sean Yang
 * Program Name: SequentialSearch
 * Date: 25/02/2025
 * Description: Implements the sequential search algorithm
 */

import java.util.Scanner;

public class SequentialSearch {

    /**
     * seqSearch searches a list linearly
     * 
     * @param list the array to search
     * @param item the item to find
     * @return the index of the item within the list (-1 if it doesn't exist)
     */
    public static int seqSearch(String[] list, String item) {
        // loop over every element and check if it matches
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }

        // return -1 if no index found
        return -1;
    }

    public static void main(String[] args) {
        // initialize scanner
        Scanner sc = new Scanner(System.in);

        // test list
        String[] myList = {
                "Hi",
                "Hello",
                "How",
                "Are",
                "You"
        };

        // ask user for query
        System.out.print("Enter your query: ");
        String query = sc.nextLine();

        // find index
        int index = seqSearch(myList, query);

        // check if index is valid
        if (index >= 0) {
            System.out.println("Found at index " + index);
        } else {
            System.out.println("String not found.");
        }
    }
}
