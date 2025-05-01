import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Programmer: Sean Yang
 * Program Name: LabTester
 * Date: 16/04/2025
 * Description: Tests the Lab and Computer class
 */
public class LabTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the maximum capacity: ");
        int maxComputers = sc.nextInt();
        sc.nextLine();

        Lab computerLab = new Lab(maxComputers);

        try {
            BufferedReader br = new BufferedReader(new FileReader("computer.txt"));
            int numComputers = Integer.parseInt(br.readLine());

            for (int i = 0; i < numComputers; i++) {
                String serial = br.readLine();
                String manufacturer = br.readLine();
                int yearMade = Integer.parseInt(br.readLine());
                int yearPurchased = Integer.parseInt(br.readLine());
                double processorSpeed = Double.parseDouble(br.readLine());
                int ramSize = Integer.parseInt(br.readLine());
                int warrantyExpiry = Integer.parseInt(br.readLine());

                computerLab.installComputer(serial, manufacturer, yearMade, yearPurchased, processorSpeed, ramSize,
                        warrantyExpiry);
            }

            br.close();
        } catch (IOException iox) {
            System.out.println("Error reading file.");
        }

        System.out.println("Average computer age: " + computerLab.averageAge());
        System.out.println("Newest computer: " + computerLab.newest());

        Computer fastest = computerLab.fastest();
        System.out.print("Fastest computer: " + fastest);
        if (fastest == computerLab.mostRam()) {
            System.out.println(". It also has the largest RAM size");
        } else {
            System.out.println(". It does not have the largest RAM size");
        }

        System.out.print("Enter a manufacturer: ");
        String query = sc.nextLine();

        System.out.println("Number of computers made by " + query + ": " + computerLab.numMadeBy(query));

        Computer[] expiring = computerLab.expiringSoon();

        System.out.println("Serial numbers of computers expiring next year:");
        for (int i = 0; i < expiring.length; i++) {
            System.out.println(expiring[i].getSerial());
        }

        sc.close();
    }
}
