
/**
 * Programmer: Sean Yang
 * Program Name: TwoPowerTable
 * Date: 21/02/2025
 * Description: Generates an HTML table of powers of two
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoPowerTable {
    public static void main(String[] args) {
        // declare scanner, buffered writer, and variables
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw;
        int maxExp;
        long currTwo;

        // take in user input
        System.out.print("Enter the maximum power of two: ");
        maxExp = sc.nextInt();

        // build table
        try {
            bw = new BufferedWriter(new FileWriter("twoPowerTable.html"));

            bw.write("<html><head>\n");
            bw.write("<title>Powers of Two</title>\n");
            bw.write("</head>\n");
            bw.write("<body>\n");
            bw.write("<table border>\n");
            bw.write("<tr><th>Exponent</th><th>Power of 2</th></tr>\n");

            currTwo = 1;
            for (int exp = 0; exp <= maxExp; exp++) {
                bw.write("<tr><td>" + exp + "</td><td>" + currTwo + "</td></tr>\n");
                currTwo *= 2;
            }

            bw.write("</table>\n");
            bw.write("</body></html>\n");

            // flush and close bw
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error accessing file.");
        }

        // close scanner
        sc.close();
    }
}
