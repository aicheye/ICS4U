import java.util.Scanner;

public class ProvinceTemps {
    public static void main(String[] args) {
        // declare scanner
        Scanner sc = new Scanner(System.in);

        // declare constants
        final int MONTH = 12;
        final int PROVINCE = 13;

        // declare variables
        String[] provinces = {"Alberta", "B.C.", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan"};
        double[][] temps;
        String queryProvince;
        boolean found;
        int coldestMonth;

        // initialize arrays
        temps = new double[PROVINCE][MONTH];

        // fill array using user inputs
        for (int i=0; i<PROVINCE; i++) {
            for (int j=0; j<MONTH; j++) {
                System.out.printf("Enter the average temperature for %s on month %d: ", provinces[i], j);
                temps[i][j] = sc.nextDouble();
            }
        }

        // ask user which province they want to find
        sc.nextLine();
        System.out.print("Which province do you want to find the coldest month for? ");
        queryProvince = sc.nextLine();
        found = false;
        coldestMonth = 1;

        for (int i=0; i<PROVINCE && !found; i++) {
            if (provinces[i].equals(queryProvince)) {
                found = true;
                for (int j=0; j<MONTH; j++) {
                    if (temps[i][j] < temps[i][coldestMonth]) coldestMonth = j;
                }
            }
        }

        if (found) System.out.printf("The coldest month in %s was month %d\n", queryProvince, coldestMonth);
        else System.out.println("Province not found!");

        // close scanner
        sc.close();
    }
}
