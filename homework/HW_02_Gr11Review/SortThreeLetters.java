/*
    Programmer: Sean Yang
    Program Name: SortThreeLetters
    Date: 04/02/2025
    Description: Outputs three letters in alphabetical order
*/

import java.util.Scanner;

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

            if ('a' <= c1 && 'a' <= c2 && 'a' <= c3 && c1 <= 'z' && c2 <= 'z' && c3 <= 'z') {
                // output sorted characters:
                System.out.print("Your characters sorted: ");

                // c1 is the first
                if (c1 <= c2 && c1 <= c3) {
                    // c2 is the second
                    if (c2 <= c3)
                        System.out.println("" + c1 + c2 + c3);
                    // c3 is the second
                    else
                        System.out.println("" + c1 + c3 + c2);
                }

                // c2 is the first
                else if (c2 <= c1 && c2 <= c3) {
                    // c1 is the second
                    if (c1 <= c3)
                        System.out.println("" + c2 + c1 + c3);
                    // c3 is the second
                    else
                        System.out.println("" + c2 + c3 + c1);
                }

                // c3 is the first
                else {
                    // c1 is the second
                    if (c1 <= c2)
                        System.out.println("" + c3 + c1 + c2);
                    // c2 is the second
                    else
                        System.out.println("" + c3 + c2 + c1);
                }
            } else {
                System.out.println("*ERR* Please only enter lowercase letters.");
            }
        } else {
            System.out.println("*ERR* Please enter only three characters.");
        }

        // close scanner
        sc.close();
    }
}
