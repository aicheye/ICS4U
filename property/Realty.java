import java.util.Scanner;

/**
 * Programmer: Sean Yang
 * Program Name: Realty
 * Description: Defines a realty which contains a property database
 * Date: 30/04/2025
 */

public class Realty {
    public static void main(String[] args) {
        final String FILENAME = "data.txt";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum # of properties: ");
        int maxProperty = sc.nextInt();

        PropertyDatabse propertyDatabse = new PropertyDatabse(maxProperty, FILENAME);

        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Choose an option:
                    1: load properties from file
                    2: list all properties
                    3: list all condominiums
                    4: list all houses
                    5: search for a property by id
                    6: search for properties by specifications
                    7: print average price of all properties in a zone
                    8: find the largest condo""");

            String input = sc.nextLine();

            try {
                switch (Integer.parseInt(input)) {
                    case 1:
                        propertyDatabse.loadProperties(FILENAME);
                        break;

                    case 2:
                        Property[] properties = propertyDatabse.getAllProperties();
                        for (int i = 0; i < properties.length; i++) {
                            System.out.println(properties[i] + "\n");
                        }
                        break;

                    case 3:
                        Condo[] condos = propertyDatabse.getAllCondos();
                        for (int i = 0; i < condos.length; i++) {
                            System.out.println(condos[i] + "\n");
                        }
                        break;

                    case 4:
                        House[] houses = propertyDatabse.getAllHouses();
                        for (int i = 0; i < houses.length; i++) {
                            System.out.println(houses[i] + "\n");
                        }
                        break;

                    case 5:
                        System.out.print("Enter the ID to search: ");
                        int queryID = sc.nextInt();
                        Property match = propertyDatabse.searchByID(queryID);

                        if (match != null) {
                            System.out.println(match + "\n");
                        } else {
                            System.out.println("No match found.\n");
                        }

                        break;

                    case 6:
                        // search by specifications
                        break;

                    case 7:
                        System.out.print("Enter a zone: ");
                        String zone = sc.nextLine();
                        System.out.printf("Average price: $%,.2f%n", propertyDatabse.averagePriceInZone(zone) + "\n");
                        break;

                    case 8:
                        System.out.println(propertyDatabse.largestCondo());
                        break;

                    default:
                        System.out.println("Must enter a valid option.\n");
                        break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Must enter a valid option.");
            }

            System.out.print("Press enter to continue.");
            sc.nextLine();
        }

        sc.close();
    }
}
