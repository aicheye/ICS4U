
/**
 * Programmer: Sean Yang
 * Program Name: ReverseLines
 * Date: 21/02/2025
 * Description: Outputs the reverse of a text file
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReverseLines {
    public static void main(String[] args) {
        // declare buffered reader and variables
        BufferedReader br;
        String line;
        int size;
        String[] lines;
        int index = 0;

        // try to access file
        try {
            br = new BufferedReader(new FileReader("reverse.txt"));

            // get first line and initialize array with # of lines
            line = br.readLine();
            size = Integer.parseInt(line);
            lines = new String[size];

            // loop until line is empty
            index = 0;
            line = br.readLine();
            while (line != null) {
                // set array value
                lines[index] = line;
                index++;
                line = br.readLine();
            }

            // output lines in reverse order
            for (int i = index - 1; i >= 0; i--) {
                System.out.println(lines[i]);
            }

            // close br
            br.close();
        } catch (IOException ex) {
            System.out.println("Error accessing file.");
        }
    }
}
