
/**
 * Programmer: Sean Yang
 * Program Name: AddNumbers
 * Date: 21/02/2025
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AddNumbers {
    public static void main(String[] args) {
        // declare buffered reader and variables
        BufferedReader br;
        String line;
        int n1;
        int n2;

        // try to open numbers
        try {
            br = new BufferedReader(new FileReader("numbers.txt"));

            // read each line
            line = br.readLine();
            while (line != null) {
                // try to parse first and second token as an integer
                n1 = Integer.parseInt(line.split(" ")[0]);
                n2 = Integer.parseInt(line.split(" ")[1]);

                // calculate sum and get next line
                System.out.printf("Sum of %d + %d = %d%n", n1, n2, n1 + n2);
                line = br.readLine();
            }

            // close br
            br.close();
        } catch (IOException ex) {
            System.out.println("Error accessing file.");
        }
    }
}
