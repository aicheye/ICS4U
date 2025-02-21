import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCases {
    public static void main(String[] args) {
        // declare buffered reader and variables
        BufferedReader br;
        String line;
        int uppers;
        int lowers;

        // try to open file
        try {
            br = new BufferedReader(new FileReader("passage.txt"));

            // loop over each line
            line = br.readLine();
            while (line != null) {
                uppers = 0;
                lowers = 0;

                // loop over each character and check if it is uppercase or lowercase
                for (int i = 0; i < line.length(); i++) {
                    if ('A' <= line.charAt(i) && line.charAt(i) <= 'Z') {
                        uppers++;
                    } else if ('a' <= line.charAt(i) && line.charAt(i) <= 'z') {
                        lowers++;
                    }
                }

                // output answer and read next line
                System.out.printf("%d uppercase letters and %d lowercase letters.%n", uppers, lowers);
                line = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error accessing file.");
        }
    }
}
