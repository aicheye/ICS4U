
/**
 * Programmer: Sean Yang
 * Program Name: Division
 * Date: 21/02/2025
 * Description: Divides numbers until the user quits
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        // declare scanner and variables
        Scanner sc = new Scanner(System.in);
        int numerator = 0;
        int divisor = 0;
        double answer;
        boolean quit = false;
        String flush;

        // take user input
        while (!quit) {
            try {
                System.out.print("Enter the numerator: ");
                numerator = sc.nextInt();
                System.out.print("Enter the divisor: ");
                divisor = sc.nextInt();

                int testDiv0 = numerator / divisor;

                answer = 0;

                // check if division by 0
                if (testDiv0 == numerator / divisor) {
                    answer = (double) numerator / divisor;
                }

                // output answer
                System.out.printf("%d divided by %d is %.2f%n%n", numerator, divisor, answer);
            } catch (InputMismatchException ex) {
                flush = sc.nextLine();

                // check if the first character is q (user quit)
                if (flush.charAt(0) == 'q') {
                    quit = true;
                } else {
                    System.out.println("You entered bad data.");
                    System.out.println("Please try again.\n");
                }
            } catch (ArithmeticException ex) {
                System.out.printf("You can't divide %d by %d%n%n", numerator, divisor);
            }
        }

        // close scanner
        sc.close();
    }
}
