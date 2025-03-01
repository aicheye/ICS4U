
/**
 * Programmer: Sean Yang
 * Program Name: RandomNumberSearchOpposite
 * Date: 26/02/2025
 * Description: Performs sequential search on an array of random integers (in the opposite directoin)
 */

import java.util.Scanner;

public class RandomNumberSearchOpposite {
    public static void main(String[] args) {
        // declare scanner and variables
        final int SIZE = 20;
        Scanner sc = new Scanner(System.in);
        int[] randInts = new int[SIZE];

        // fill random integers
        for (int i = 0; i < SIZE; i++) {
            randInts[i] = (int) (Math.random() * 20) + 1;
        }

        // take user query and check if it is in the list
        System.out.print("Enter an integer (1-20): ");
        int query = sc.nextInt();

        // sequential search (top to bottom)
        int index = -1;
        for (int i = SIZE - 1; i >= 0; i--) {
            if (randInts[i] == query)
                index = i;
        }

        // output answer
        if (index >= 0) {
            System.out.println("Found at index " + index);
        } else {
            System.out.println("Not found.");
        }

        // close scanner
        sc.close();
    }
}
