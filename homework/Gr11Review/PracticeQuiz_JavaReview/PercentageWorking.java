import java.util.Scanner;

public class PercentageWorking {
    public static void main(String[] args) {
        // declare constant
        final int DAYS_IN_YEAR = 365;

        // declare Scanner
        Scanner sc = new Scanner(System.in);

        // declare variables
        int msDays;
        int mrDays;

        // take inputs
        System.out.println("# of days worked");
        System.out.print("Ms. Jackson: ");
        msDays = sc.nextInt();
        System.out.print("Mr. Jackson: ");
        mrDays = sc.nextInt();
        System.out.println();

        // output answers
        System.out.printf("Ms. Jackson: %.0f%%\n", (double) msDays / DAYS_IN_YEAR * 100);
        System.out.printf("Mr. Jackson: %.0f%%\n", (double) mrDays / DAYS_IN_YEAR * 100);
        System.out.printf("Average: %.0f%%\n", (double) (msDays + mrDays) / (DAYS_IN_YEAR * 2) * 100);

        // close scanner
        sc.close();
    }
}
