
/**
 * Programmer: Sean Yang
 * Program Name: HouseSpec
 * Description: Specifications for a house
 * Date: 01/05/2025
 */

public class HouseSpec extends SecondarySpec {
    private boolean vacuum;
    private boolean ac;
    private boolean fireplace;
    private boolean hardwood;
    private boolean basement;
    public static final int NUM_SPEC = 5;

    /**
     * specifications for a house
     * 
     * @param vacuum    whether there is a vacuum
     * @param ac        whether there is air conditioning
     * @param fireplace whether there is a fireplace
     * @param hardwood  whether there are hardwood floors
     * @param basement  whether there is a finished basement
     */
    public HouseSpec(boolean vacuum, boolean ac, boolean fireplace, boolean hardwood, boolean basement) {
        this.vacuum = vacuum;
        this.ac = ac;
        this.fireplace = fireplace;
        this.hardwood = hardwood;
        this.basement = basement;
    }

    /**
     * what percentage of this specification is matched by the target specification
     * 
     * @return what percentage of this specification matches
     */
    public boolean matchSpec(SecondarySpec other, double minPercent) {
        if (other instanceof HouseSpec houseSpec && other != null) {
            double matching = 0;

            if (vacuum == houseSpec.vacuum) {
                matching++;
            }
            if (ac == houseSpec.ac) {
                matching++;
            }
            if (fireplace == houseSpec.fireplace) {
                matching++;
            }
            if (hardwood == houseSpec.hardwood) {
                matching++;
            }
            if (basement == houseSpec.basement) {
                matching++;
            }

            if (matching / NUM_SPEC >= minPercent) {
                return true;
            }
        }

        return false;
    }

    /**
     * converts this house specification to a string
     * 
     * @return the string
     */
    public String toString() {
        String houseString = "Vacuum: ";
        houseString += vacuum ? "Y" : "N";
        houseString += ", Air Conditioning: ";
        houseString += ac ? "Y" : "N";
        houseString += ", Fireplace: ";
        houseString += fireplace ? "Y" : "N";
        houseString += ", Hardwood Floors: ";
        houseString += hardwood ? "Y" : "N";
        houseString += ", Finished Basement: ";
        houseString += basement ? "Y" : "N";

        return houseString;
    }
}
