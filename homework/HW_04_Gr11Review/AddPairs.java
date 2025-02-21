
/**
 * Programmer: Sean Yang
 * Program Name: AddPairs
 * Date: 21/02/2025
 * Description: Finds the sum of two-digit pairs in a number
 */

import java.util.Scanner;

public class AddPairs {
    public static void main(String[] args) {
        // declare scanner and variables
        Scanner sc = new Scanner(System.in);
        String input;
        int ans;

        // take input
        input = sc.nextLine();

        // calculate the pairs of numbers and add to answer
        ans = 0;

        for (int i = 0; i < input.length() - 1; i += 2) {
            ans += (input.charAt(i) - '0') * 10;
            ans += input.charAt(i + 1) - '0';
        }

        if (input.length() % 2 == 1) {
            ans += input.charAt(input.length() - 1) - '0';
        }

        // output answer
        System.out.println(ans);

        // close scanner
        sc.close();
    }
}
