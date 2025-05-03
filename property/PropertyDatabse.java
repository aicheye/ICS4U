import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PropertyDatabse {
    private final int maxProperty;
    private int numProperty;
    private Property[] propertyList;

    /**
     * loads the property list into the array from a file
     * 
     * @param fileName the file to load from
     */
    void loadProperties(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            numProperty = Integer.parseInt(br.readLine());

            if (numProperty > maxProperty) {
                numProperty = maxProperty;
            }

            br.readLine();

            for (int i = 0; i < numProperty; i++) {
                String type = br.readLine();

                int id = Integer.parseInt(br.readLine());
                String address = br.readLine();
                String zone = br.readLine();
                int price = Integer.parseInt(br.readLine());
                int size = Integer.parseInt(br.readLine());
                int numBedrooms = Integer.parseInt(br.readLine());

                if (type.equals("house")) {
                    boolean vacuum = br.readLine().equals("Y");
                    boolean ac = br.readLine().equals("Y");
                    boolean fireplace = br.readLine().equals("Y");
                    boolean hardwood = br.readLine().equals("Y");
                    boolean basement = br.readLine().equals("Y");

                    propertyList[i] = new House(id, address, zone, price, size, numBedrooms, vacuum, ac, fireplace,
                            hardwood, basement);
                } else {
                    boolean pool = br.readLine().equals("Y");
                    boolean exRoom = br.readLine().equals("Y");
                    boolean locker = br.readLine().equals("Y");
                    boolean hydroIncluded = br.readLine().equals("Y");
                    boolean cableIncluded = br.readLine().equals("Y");

                    propertyList[i] = new Condo(id, address, zone, price, size, numBedrooms, pool, exRoom, locker,
                            hydroIncluded, cableIncluded);
                }

                if (i < numProperty - 1) {
                    br.readLine();
                }
            }

            br.close();
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    /**
     * constructor for a property database
     * 
     * @param maxProperty maximum number of properties which will be stored
     * @param fileName    the file name to load from
     */
    public PropertyDatabse(int maxProperty, String fileName) {
        this.maxProperty = maxProperty;
        propertyList = new Property[maxProperty];
        loadProperties(fileName);
    }

    /**
     * accessor for all properties in the database
     * 
     * @return an array of all properties in the database
     */
    public Property[] getAllProperties() {
        Property[] trimmedPropertyList = new Property[numProperty];

        for (int i = 0; i < numProperty; i++) {
            trimmedPropertyList[i] = propertyList[i];
        }

        return trimmedPropertyList;
    }

    /**
     * finds a property with a given id
     * 
     * @param id the id to search for
     * @return a property object matching the id, or null if none is found
     */
    public Property searchByID(int id) {
        for (int i = 0; i < numProperty; i++) {
            if (propertyList[i].getID() == id) {
                return propertyList[i];
            }
        }

        return null;
    }

    /**
     * gets an array of all properties which match the specifications
     * 
     * @param primSpec   the primary specification
     * @param secSpec    the secondary specification
     * @param minPercent the minimum percent required for the secondary
     *                   specifications to be matching by
     * @return an array of properties which match
     */
    public Property[] getAllMatches(PrimarySpec primSpec, SecondarySpec secSpec, double minPercent) {
        Property[] matchingProperties = new Property[maxProperty];
        int numMatching = 0;

        for (int i = 0; i < numProperty; i++) {
            if (propertyList[i].matchProperty(primSpec, secSpec, minPercent)) {
                matchingProperties[numMatching++] = propertyList[i];
            }
        }

        Property[] trimmedMatchingProperties = new Property[numMatching];
        for (int i = 0; i < numMatching; i++) {
            trimmedMatchingProperties[i] = matchingProperties[i];
        }

        return trimmedMatchingProperties;
    }

    /**
     * gets an array of all houses in the database
     * 
     * @return an array of houses in the database
     */
    public House[] getAllHouses() {
        House[] houses = new House[maxProperty];
        int numHouses = 0;

        for (int i = 0; i < numProperty; i++) {
            if (propertyList[i] instanceof House house) {
                houses[numHouses++] = house;
            }
        }

        House[] trimmedHouses = new House[numHouses];
        for (int i = 0; i < numHouses; i++) {
            trimmedHouses[i] = houses[i];
        }

        return trimmedHouses;
    }

    /**
     * gets an array of all condos in the database
     * 
     * @return an array of condos in the database
     */
    public Condo[] getAllCondos() {
        Condo[] condos = new Condo[maxProperty];
        int numCondos = 0;

        for (int i = 0; i < numProperty; i++) {
            if (propertyList[i] instanceof Condo condo) {
                condos[numCondos++] = condo;
            }
        }

        Condo[] trimmedCondos = new Condo[numCondos];
        for (int i = 0; i < numCondos; i++) {
            trimmedCondos[i] = condos[i];
        }

        return trimmedCondos;
    }

    /**
     * calculates the average price of properties in a specified zone
     * 
     * @param zone the zone to search in
     * @return a double, the average price
     */
    public double averagePriceInZone(String zone) {
        double sum = 0;

        for (int i = 0; i < numProperty; i++) {
            PrimarySpec primSpec = propertyList[i].getPrimarySpec();

            if (primSpec.getZoneCode().equals(zone)) {
                sum += primSpec.getPrice();
            }
        }

        return sum / numProperty;
    }

    /**
     * finds the largest condo by square feet in the property list
     * 
     * @return the largest condo object
     */
    public Condo largestCondo() {
        Condo largestCondo = null;
        int largestSize = 0;

        for (int i = 0; i < numProperty; i++) {
            if (propertyList[i] instanceof Condo condo) {
                int size = condo.getPrimarySpec().getSize();

                if (largestCondo == null || size > largestSize) {
                    largestCondo = condo;
                    largestSize = size;
                }
            }
        }

        return largestCondo;
    }
}
