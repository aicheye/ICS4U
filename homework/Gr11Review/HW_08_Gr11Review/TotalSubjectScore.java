
/**
 * Programmer: Sean Yang
 * Program Name: TotalSubjectScore
 * Date: 21/02/2025
 * Description: Outputs scores for various sections
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TotalSubjectScore {
    public static void main(String[] args) {
        // declare scanner and variables
        BufferedReader br;
        String section;
        String line;
        double sum;
        int scores;

        // attempt to open file
        try {
            br = new BufferedReader(new FileReader("scores.txt"));

            section = br.readLine();
            line = br.readLine();
            sum = 0;
            scores = 0;

            // loop until EOF
            while (line != null) {
                try {
                    // try to add line onto sum
                    sum += Integer.parseInt(line);
                    scores++;
                } catch (NumberFormatException ex) {
                    // if line is not a number and ends in a colon, output average
                    if (line.charAt(line.length() - 1) == ':') {
                        System.out.print(section);

                        // check if there are no scores for this section
                        if (scores == 0) {
                            System.out.println(" - Average Score: N/A");
                        } else {
                            System.out.printf(" - Average Score: %.1f%n", sum / scores);
                        }

                        // change section
                        section = line;
                        sum = 0;
                        scores = 0;
                    }
                } finally {
                    // read next line
                    line = br.readLine();
                }
            }

            // output the last group
            System.out.print(section);
            System.out.printf(" - Average Score: %.1f%n", sum / scores);

        } catch (IOException ex) {
            System.out.println("Error accessing file.");
        }
    }
}
