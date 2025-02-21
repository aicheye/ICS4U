
/**
 * Programmer: Sean Yang
 * Program Name: DataEntry
 * Date: 21/02/2025
 * Description: Calculates the final result given data and operators
 */

import java.util.Scanner;

public class DataEntry {
    public static void main(String[] args) {
        // declare scanner and variables
        Scanner sc = new Scanner(System.in);
        int total = 0;
        boolean add = true;
        String line;

        // loop until the user quits
        line = sc.nextLine();

        while (!line.equals("quit")) {
            // check if this line is an integer
            try {
                // try to add/subtract based on operator
                if (add) {
                    total += Integer.parseInt(line);
                } else {
                    total -= Integer.parseInt(line);
                }
            } catch (NumberFormatException ex) {
                // if this is not a number, check if it is a plus or minus
                if (line.charAt(0) == '+') {
                    add = true;
                } else if (line.charAt(0) == '-') {
                    add = false;
                }
            } finally {
                // take next line
                line = sc.nextLine();
            }
        }

        // output total
        System.out.println("The final result is " + total);

        // close scanner
        sc.close();
    }
}
