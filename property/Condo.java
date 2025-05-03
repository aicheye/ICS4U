
/**
 * Programmer: Sean Yang
 * Program Name: Condo
 * Description: Describes a condo object
 * Date: 01/05/2025
 */

public class Condo extends Property {

    /**
     * constructor for a condo object
     * 
     * @param id            the property ID
     * @param address       the address of the condo building
     * @param zoneCode      the area the condi is in
     * @param price         price in dollars
     * @param size          size in square feet
     * @param numBedroom
     * @param pool          whether there is a pool in the building
     * @param exRoom        whether there is an exercise room in the building
     * @param locker        whether a locker is included
     * @param hydroIncluded whether hydro is included
     * @param cableIncluded whether cable is included
     */
    public Condo(int id, String address, String zoneCode, int price, int size, int numBedroom, boolean pool,
            boolean exRoom, boolean locker, boolean hydroIncluded, boolean cableIncluded) {
        super(id, address, new PrimarySpec(zoneCode, price, size, numBedroom),
                new CondoSpec(pool, exRoom, locker, hydroIncluded, cableIncluded));
    }
}
