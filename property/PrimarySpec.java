
/**
 * Programmer: Sean Yang
 * Program Name: PrimarySpec
 * Description: Primary specifications for a property
 * Date: 01/05/2025
 */

public class PrimarySpec {
    private String zoneCode;
    private int price;
    private int size;
    private int numBedroom;

    /**
     * constructor for a primary specification object
     * 
     * @param zoneCode   the area of the property
     * @param price      the maximum price in dollars
     * @param size       the minimum size of the property in square feet
     * @param numBedroom the minimum number of bedrooms
     */
    public PrimarySpec(String zoneCode, int price, int size, int numBedroom) {
        this.zoneCode = zoneCode;
        this.price = price;
        this.size = size;
        this.numBedroom = numBedroom;
    }

    /**
     * accessor for the zone code
     * 
     * @return a string, the zone code
     */
    String getZoneCode() {
        return this.zoneCode;
    }

    /**
     * accessor for the price
     * 
     * @return an integer, the price
     */
    int getPrice() {
        return this.price;
    }

    /**
     * accessor for the size
     * 
     * @return an integer, the size in square feet
     */
    int getSize() {
        return this.size;
    }

    /**
     * returns whether this primary specification matches the minimum requirements
     * of another primary specification
     * 
     * @param zoneCode
     * @param price
     * @param size
     * @param numBedroom
     * @return whether this primary specification matches the minimum requirements
     */
    public boolean matchSpec(PrimarySpec other) {
        if (other == null) {
            return false;
        }

        return this.zoneCode.equals(other.zoneCode) &&
                this.price <= other.price &&
                this.size >= other.size &&
                this.numBedroom >= other.numBedroom;
    }

    /**
     * converts this object to a string
     * 
     * @return returns various information about this specification as a string
     */
    public String toString() {
        return String.format("Zone Code: %s, Price: $%,d, Size: %dsqft, Number of Bedrooms: %d", zoneCode, price, size,
                numBedroom);
    }
}
