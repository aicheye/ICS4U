
/**
 * Programmer: Sean Yang
 * Program Name: PrintLines
 * Date: 21/02/2025
 * Description: Reads each line in a file and outputs them to standard output
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintLines {
    public static void main(String[] args) {
        // declare buffered reader and variables
        BufferedReader br;
        String line;

        // try to access file
        try {
            br = new BufferedReader(new FileReader("line.txt"));

            // loop until line is empty
            line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

            // close br
            br.close();
        } catch (IOException ex) {
            System.out.println("Error accessing file.");
        }
    }
}
