import java.util.Scanner;

/**
 * Programmer: Sean Yang
 * Program Name: TowerOfHanoi
 * Date: 06/03/2025
 * Description: Solves tower of hanoi
 */

public class TowerOfHanoi {
    /**
     * hanoi recursive wrapper function to solve tower of hanoi
     * 
     * @param disks the number of disks
     */
    public static void hanoi(int disks) {
        hanoi(disks, 1, 3);
    }

    /**
     * hanoi recursive function to solve tower of hanoi
     * 
     * @param disks the number of disks on the current peg
     * @param curr  the current peg
     * @param goal  the goal peg
     */
    private static void hanoi(int disks, int curr, int goal) {
        if (disks == 1) {
            System.out.println("Move from " + curr + " to " + goal);
            return;
        }

        int other = 6 - curr - goal;

        hanoi(disks - 1, curr, other);

        // hanoi(1, curr, goal);
        System.out.println("Move from " + curr + " to " + goal);

        hanoi(disks - 1, other, goal);
    }

    public static void main(String[] args) {
        // declare variables
        Scanner sc = new Scanner(System.in);

        // get user input
        System.out.print("Enter the number of disks: ");
        int disks = sc.nextInt();

        // call tower of hanoi
        hanoi(disks);

        // close scanner
        sc.close();
    }
}
