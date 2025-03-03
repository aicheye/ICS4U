
/**
 * Programmer: Sean Yang
 * Program Name: CheckLine
 * Date: 21/02/2025
 * Description: Asks users for coordinates of two lines and checks if they are 
 * perpendicular or parallel
 */

import java.util.Scanner;
import HW_05_Gr11Review.Line;

public class CheckLine {
    public static void main(String[] args) {
        // declare scanner and variables
        Scanner sc = new Scanner(System.in);
        int x1;
        int y1;
        int x2;
        int y2;
        double length1 = 0;
        double length2 = 0;
        double slope1 = 0;
        double slope2 = 0;

        // take user input
        for (int i=1; i<=2; i++) {
            System.out.println("Please enter the two coordinates of line " + i + ":");
            System.out.print("Vertex 1 x-value:   ");
            x1 = sc.nextInt();
            System.out.print("Vertex 1 y-value:   ");
            y1 = sc.nextInt();

            System.out.print("\nVertex 2 x-value:   ");
            x2 = sc.nextInt();
            System.out.print("Vertex 2 y-value:   ");
            y2 = sc.nextInt();

            // calculate length1 and slope1;
            if (i == 1) {
                length1 = Line.length(x1, y1, x2, y2);
                slope1 = Line.slope(x1, y1, x2, y2);
            }
            else {
                length2 = Line.length(x1, y1, x2, y2);
                slope2 = Line.slope(x1, y1, x2, y2);
            }
        }

        // output results
        System.out.println("\nResults:");

        // check if they have the same length
        if (length1 == length2) {
            System.out.println("The two lines have the same length.");
        } else {
            System.out.println("The two lines do not have the same length.");
        }

        // check if they are parallel
        if (slope1 == slope2) {
            System.out.println("The two lines are parallel.");
        } else {
            // check if they are perpendicular
            if (slope1 == -1 / slope2) {
                System.out.println("The two lines are perpendicular");
            } else {
                System.out.println("The two lines are not parallel or perpendicular.");
            }
        }

        // close scanner
        sc.close();
    }
}
