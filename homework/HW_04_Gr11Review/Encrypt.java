
/**
 * Programmer: Sean Yang
 * Program Name: Encrypt
 * Date: 12/02/2025
 * Description: Encrypts a line of code
 */

import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        // declare scanner and variables
        Scanner sc = new Scanner(System.in);
        String input;
        String secret;
        String[] words;

        // take in input and initialize words
        input = sc.nextLine();
        words = input.split(" ");

        secret = "";
        // iterate over each word
        for (int i = 0; i < words.length; i++) {
            // put the last character first
            secret += words[i].charAt(words[i].length() - 1);

            // loop over the middle characters, and shift by 2
            for (int j = 1; j < words[i].length() - 1; j++) {
                secret += (char) (words[i].charAt(j) + 2);
            }

            // if the word is at least two characters, add the first character
            if (words[i].length() >= 2) {
                secret += words[i].charAt(0);
            }

            // add a space between words
            secret += " ";
        }

        // output the encrypted sentence
        System.out.println("The encryption is: " + secret);

        // close scanner
        sc.close();
    }
}
