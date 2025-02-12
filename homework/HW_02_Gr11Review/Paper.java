/**
 * Programmer: Sean Yang
 * Program Name: Paper
 * Date: 04/02/2025
 * Description: Calculates the thickness and area of a piece of paper after it
 * has been cut and folded 40 times
 */

public class Paper {
    public static void main(String[] args) {
        // declare constants
        final int MM_PER_M = 1000; // 1000mm/m
        final int M_PER_KM = 1000; // 1000m/km

        // declare variables
        double area = 1.0; // m^2
        double thickness = 0.090; // mm

        // convert area to mm^2 for readability
        area *= MM_PER_M * MM_PER_M;

        // cut and stack 40 times
        for (int i = 0; i < 40; i++) {
            area /= 2;
            thickness *= 2;
        }

        // convert thickness to km for readability
        thickness /= (MM_PER_M * M_PER_KM);

        // output the result
        System.out.println("After 40 cuts and stacks of a 1m^2 sheet of paper:");
        System.out.printf("The thickness of the pile is %,.2f km\n", thickness);
        System.out.printf("The area of each piece is %.12f mm^2\n", area);
    }
}
