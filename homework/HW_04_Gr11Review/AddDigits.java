
/**
 * Programmer: Sean Yang
 * Program Name: AddDigits
 * Date: 20/02/2025
 * Description:
 */

import java.util.Scanner;

public class AddDigits {
    public static void main(String[] args) {
        // declare scanner and variables
        Scanner sc = new Scanner(System.in);
        String input;
        int ans;

        // take input
        input = sc.nextLine();

        // calculate answer
        ans = 0;
        for (int i = 0; i < input.length(); i++) {
            ans += input.charAt(i) - '0';
        }
        System.out.println(ans);

        // close scanner
        sc.close();
    }
}
