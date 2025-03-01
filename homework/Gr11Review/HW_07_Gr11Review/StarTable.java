
/**
 * Programmer: Sean Yang
 * Program Name: StarTable
 * Date: 21/02/2025
 * Description: Outputs a table to star.txt
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StarTable {
    public static void main(String[] args) {
        // declare scanner, buffered writer, and variables
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw;
        int width;
        int height;
        char[][] table;

        // take user inputs
        System.out.print("Enter the width: ");
        width = sc.nextInt();
        System.out.print("Enter the height: ");
        height = sc.nextInt();

        // initialize table
        table = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                table[i][j] = '*';
            }
        }

        // write table to file
        try {
            bw = new BufferedWriter(new FileWriter("star.txt"));

            // loop over the table
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    bw.write(table[i][j]);
                }
                bw.write("\n");
            }

            // flush and close bw
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error while accessing file.");
        }
        // close scanner
        sc.close();
    }
}
