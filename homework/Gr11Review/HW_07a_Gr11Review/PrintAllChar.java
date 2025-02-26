
/**
 * Programmer: Sean Yang
 * Program Name: PrintLines
 * Date: 21/02/2025
 * Description: Reads each character in a file and outputs them in a new line
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintAllChar {
    public static void main(String[] args) {
        // declare buffered reader and variables
        BufferedReader br;
        String line;

        // try to access file
        try {
            br = new BufferedReader(new FileReader("allChar.txt"));

            // loop until line is empty
            line = br.readLine();
            while (line != null) {
                // loop over each character and output it if it is not empty
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != ' ' && line.charAt(i) != '\n' && line.charAt(i) != '\r') {
                        System.out.println(line.charAt(i));
                    }
                }
                line = br.readLine();
            }

            // close br
            br.close();
        } catch (IOException ex) {
            System.out.println("Error accessing file.");
        }
    }
}
