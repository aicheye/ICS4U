
/**
 * Programmer: Sean Yang
 * Program Name: Property
 * Description: Class describing a property
 * Date: 01/05/2025
 */

public class Property {
    private int id;
    private String address;
    private PrimarySpec primSpec;
    private SecondarySpec secSpec;

    /**
     * constructor class for a property object
     * 
     * @param id       the property ID
     * @param address  the property address
     * @param primSpec the primary specification
     * @param secSpec  the secondary specification
     */
    public Property(int id, String address, PrimarySpec primSpec, SecondarySpec secSpec) {
        this.id = id;
        this.address = address;
        this.primSpec = primSpec;
        this.secSpec = secSpec;
    }

    /**
     * accessor for the property id
     * 
     * @return the property id
     */
    int getID() {
        return this.id;
    }

    /**
     * accessor for primary specification
     * 
     * @return the primary specification
     */
    PrimarySpec getPrimarySpec() {
        return this.primSpec;
    }

    /**
     * matches the specifications of this property
     * 
     * @param primSpec   the minimum primary specification
     * @param secSpec    the secondary specification
     * @param minPercent the minimum percent of the second specification matching
     * @return whether this property meets the requirements
     */
    public boolean matchProperty(PrimarySpec primSpec, SecondarySpec secSpec, double minPercent) {
        if (this.primSpec.matchSpec(primSpec) && this.secSpec.matchSpec(secSpec, minPercent)) {
            return true;
        }

        return false;
    }

    /**
     * converts this property object to a string
     * 
     * @return string representation of this property
     */
    public String toString() {
        return String.format("ID: %d%nAddress: %s%nPrimary Specification: %s%nSecondary Specification: %s", id,
                address, primSpec, secSpec);
    }
}
