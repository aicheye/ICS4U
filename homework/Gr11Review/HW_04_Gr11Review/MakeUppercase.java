
/**
 * Programmer: Sean Yang
 * Program Name: MakeUppercase
 * Date: 12/02/2025
 * Description: Makes a string uppercase
 */

import java.util.Scanner;

public class MakeUppercase {
    public static void main(String[] args) {
        // initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        String queryString;
        char character;
        String uppercase;

        // take user input
        System.out.print("Enter sting: ");
        queryString = sc.nextLine();

        // initialize uppercase
        uppercase = "";

        // loop over each character
        for (int i = 0; i < queryString.length(); i++) {
            character = queryString.charAt(i);
            // check if it is a lower case letter. if so, make it uppercase
            if ('a' <= character && character <= 'z') {
                character = (char) ('A' + (character - 'a'));
            }
            // append character to uppercase string
            uppercase += character;
        }

        // output new string
        System.out.println("Uppercase Equivalent: " + uppercase);

        // close scanner
        sc.close();
    }
}
