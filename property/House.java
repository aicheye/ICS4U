
/**
 * Programmer: Sean Yang
 * Program Name: House
 * Description: Describes a house object
 * Date: 01/05/2025
 */

public class House extends Property {

    /**
     * constructor for house object
     * 
     * @param id         property ID
     * @param address
     * @param zoneCode   the area the house is in
     * @param price      price in dollars
     * @param size       size in square feet
     * @param numBedroom
     * @param vacuum     whether there is a vacuum
     * @param ac         whether there is air conditioning
     * @param fireplace  whether there is a fireplace
     * @param hardwood   whether there is hardwood flooring
     * @param basement   whether the basement is finished
     */
    public House(int id, String address, String zoneCode, int price, int size, int numBedroom, boolean vacuum,
            boolean ac, boolean fireplace, boolean hardwood, boolean basement) {
        super(id, address, new PrimarySpec(zoneCode, price, size, numBedroom),
                new HouseSpec(vacuum, ac, fireplace, hardwood, basement));
    }
}
