
/**
 * Programmer: Sean Yang
 * Program Name: FastFoodTotal
 * Date: 04/02/2025
 * Description: Calculates the total and change due of a fast food order
 */

import java.util.Scanner;

public class FastFoodTotal {
    public static void main(String[] args) {
        // initialize constants
        final double BURGER_COST = 1.69;
        final double FRIES_COST = 1.09;
        final double SODAS_COST = 0.99;
        final double PST_PERCENT = 0.08;
        final double GST_PERCENT = 0.05;

        // initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        int burgers, fries, sodas;
        double subtotal;
        double pst, gst;
        double total;
        double tendered;

        // take inputs
        System.out.print("Enter the number of burgers bought: ");
        burgers = sc.nextInt();

        System.out.print("Enter the number of fries bought: ");
        fries = sc.nextInt();

        System.out.print("Enter the number of sodas bought: ");
        sodas = sc.nextInt();

        // calculate amounts
        subtotal = burgers * BURGER_COST + fries * FRIES_COST + sodas * SODAS_COST;
        System.out.printf("\nSubtotal:    $%,7.2f\n", subtotal);

        pst = subtotal * PST_PERCENT;
        System.out.printf("PST:         $%,7.2f\n", pst);

        gst = subtotal * GST_PERCENT;
        System.out.printf("GST:         $%,7.2f\n", gst);

        total = Math.round(subtotal * 100) / 100.0 +
                Math.round(pst * 100) / 100.0 +
                Math.round(gst * 100) / 100.0;
        System.out.printf("Total:       $%,7.2f\n", total);

        // take in amount tendered
        System.out.print("\nEnter amount tendered: $");
        tendered = sc.nextDouble();

        // output change due
        System.out.printf("Change due:  $%,7.2f\n", tendered - total);

        // close scanner
        sc.close();
    }
}
