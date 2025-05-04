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
        sc.nextLine();

        PropertyDatabase propertyDatabase = new PropertyDatabase(maxProperty, FILENAME);

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
                        propertyDatabase.loadProperties(FILENAME);
                        break;

                    case 2:
                        Property[] properties = propertyDatabase.getAllProperties();
                        for (int i = 0; i < properties.length; i++) {
                            System.out.println("\n" + properties[i]);
                        }
                        break;

                    case 3:
                        Condo[] condos = propertyDatabase.getAllCondos();
                        for (int i = 0; i < condos.length; i++) {
                            System.out.println("\n" + condos[i]);
                        }
                        break;

                    case 4:
                        House[] houses = propertyDatabase.getAllHouses();
                        for (int i = 0; i < houses.length; i++) {
                            System.out.println("\n" + houses[i]);
                        }
                        break;

                    case 5:
                        System.out.print("Enter the ID to search: ");
                        int queryID = sc.nextInt();
                        sc.nextLine();
                        Property match = propertyDatabase.searchByID(queryID);

                        if (match != null) {
                            System.out.println("\n" + match);
                        } else {
                            System.out.println("No match found.");
                        }

                        break;

                    case 6:
                        System.out.print("Search for [h]ouse or [c]ondo? ");
                        String type = sc.nextLine().toLowerCase();

                        if (!type.equals("h") && !type.equals("c")) {
                            System.out.println("Must enter a valid option.");
                            break;
                        }

                        System.out.print("Zone to search in: ");
                        String zoneCode = sc.nextLine();

                        System.out.print("Maximum price: $");
                        int price = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Minimum size (sqft): ");
                        int size = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Minimum number of bedrooms: ");
                        int numBedroom = sc.nextInt();
                        sc.nextLine();

                        PrimarySpec primSpec = new PrimarySpec(zoneCode, price, size, numBedroom);
                        SecondarySpec secSpec;

                        if (type.charAt(0) == 'h') {
                            System.out.print("Vacuum included (y/n): ");
                            boolean vacuum = sc.nextLine().toLowerCase().equals("y");

                            System.out.print("Air conditioning (y/n): ");
                            boolean ac = sc.nextLine().toLowerCase().equals("y");

                            System.out.print("Fireplace (y/n): ");
                            boolean fireplace = sc.nextLine().toLowerCase().equals("y");

                            System.out.print("Hardwood floors (y/n): ");
                            boolean hardwood = sc.nextLine().toLowerCase().equals("y");

                            System.out.print("Finished basement (y/n): ");
                            boolean basement = sc.nextLine().toLowerCase().equals("y");

                            secSpec = new HouseSpec(vacuum, ac, fireplace, hardwood, basement);
                        } else {
                            System.out.print("Pool (y/n): ");
                            boolean pool = sc.nextLine().toLowerCase().equals("y");

                            System.out.print("Exercise room (y/n): ");
                            boolean exRoom = sc.nextLine().toLowerCase().equals("y");

                            System.out.print("Locker (y/n): ");
                            boolean locker = sc.nextLine().toLowerCase().equals("y");

                            System.out.print("Hydro included (y/n): ");
                            boolean hydroIncluded = sc.nextLine().toLowerCase().equals("y");

                            System.out.print("Cable included (y/n): ");
                            boolean cableIncluded = sc.nextLine().toLowerCase().equals("y");

                            secSpec = new CondoSpec(pool, exRoom, locker, hydroIncluded, cableIncluded);
                        }

                        System.out.print("Minimum % of secondary specifications matching (0-100): ");
                        double minPercent = (double) sc.nextInt() / 100;

                        Property[] matchingProperties = propertyDatabase.getAllMatches(primSpec, secSpec, minPercent);

                        if (matchingProperties.length == 0) {
                            System.out.println("\nNo matches found.");
                        }

                        for (int i = 0; i < matchingProperties.length; i++) {
                            System.out.println("\n" + matchingProperties[i]);
                        }

                        sc.nextLine();

                        break;

                    case 7:
                        System.out.print("Enter a zone: ");
                        String zone = sc.nextLine();
                        System.out.printf("Average price: $%,.2f%n", propertyDatabase.averagePriceInZone(zone));
                        break;

                    case 8:
                        System.out.println("\n" + propertyDatabase.largestCondo());
                        break;

                    default:
                        System.out.println("Must enter a valid option.");
                        break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Must enter a valid option.");
            }

            System.out.print("\nPress enter to continue.");
            sc.nextLine();
        }

        sc.close();
    }
}
