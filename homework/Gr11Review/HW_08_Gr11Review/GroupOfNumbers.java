
/**
 * Programmer: Sean Yang
 * Program Name: GroupOfNumbers
 * Date: 21/02/2025
 * Description: Outputs sums of groups of numbers
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GroupOfNumbers {
    public static void main(String[] args) {
        // declare scanner and variables
        BufferedReader br;
        String group;
        String line;
        int sum;

        // attempt to open file
        try {
            br = new BufferedReader(new FileReader("input.txt"));

            group = br.readLine();
            line = br.readLine();
            sum = 0;

            // loop until EOF
            while (line != null) {
                try {
                    // try to add line onto sum
                    sum += Integer.parseInt(line);
                } catch (NumberFormatException ex) {
                    // if line is not a number, output the sum and go to new group
                    System.out.println(group);
                    System.out.println("sum = " + sum + "\n");
                    group = line;
                    sum = 0;
                } finally {
                    // read next line
                    line = br.readLine();
                }
            }

            // output the last group
            System.out.println(group);
            System.out.println("sum = " + sum + "\n");

        } catch (IOException ex) {
            System.out.println("Error accessing file.");
        }
    }
}
