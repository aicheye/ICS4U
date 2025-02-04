/*
 Programmer: Sean Yang
 Program Name: SortThreeLetters
 Date: 04/02/2025
 Description: Outputs three letters in alphabetical order
 */

import java.util.*;

public class SortThreeLetters {
    public static void main(String[] args) {
        // initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        String in;
        char c1, c2, c3;

        // take in characters
        System.out.print("Enter three characters: ");
        in = sc.nextLine();

        // validate input
        if (in.length() == 3) {
            c1 = in.charAt(0);
            c2 = in.charAt(1);
            c3 = in.charAt(2);

            if (97 <= c1 && 97 <= c2 && 97 <= c3 && c1 <= 122 && c2 <= 122 && c3 <= 122) {
                // output sorted characters:
                System.out.print("Your characters sorted: ");

                if (c1 <= c2 && c2 <= c3) {
                    System.out.println("" + c1 + c2 + c3);
                }
                else if (c1 <= c3 && c3 <= c2) {
                    System.out.println("" + c1 + c3 + c2);
                }
                else if (c2 <= c1 && c1 <= c3) {
                    System.out.println("" + c2 + c1 + c3);
                }
                else if (c2 <= c3) {
                    System.out.println("" + c2 + c3 + c1);
                }
                else if (c1 <= c2) {
                    System.out.println("" + c3 + c1 + c2);
                }
                else {
                    System.out.println("" + c3 + c2 + c1);
                }
            }
            else {
                System.out.println("*ERR* Please only enter lowercase letters.");
            }
        }
        else {
            System.out.println("*ERR* Please enter only three characters.");
        }
    }
}
