
/**
 * Programmer: Sean Yang
 * Program Name: CondoSpec
 * Description: Specifications for a condo
 * Date: 01/05/2025
 */

public class CondoSpec extends SecondarySpec {
    private boolean pool;
    private boolean exRoom;
    private boolean locker;
    private boolean hydroIncluded;
    private boolean cableIncluded;
    public static final int NUM_SPEC = 5;

    /**
     * specifications for a condominium
     * 
     * @param pool          whether there is a pool
     * @param exRoom        whether there is an exercise room
     * @param locker        whether there is a locker
     * @param hydroIncluded
     * @param cableIncluded
     */
    public CondoSpec(boolean pool, boolean exRoom, boolean locker, boolean hydroIncluded, boolean cableIncluded) {
        this.pool = pool;
        this.exRoom = exRoom;
        this.locker = locker;
        this.hydroIncluded = hydroIncluded;
        this.cableIncluded = cableIncluded;
    }

    /**
     * what percentage of this specification is matched by the target specification
     * 
     * @return what percentage of this specification matches
     */
    public boolean matchSpec(SecondarySpec other, double minPercent) {
        if (other instanceof CondoSpec condoSpec && other != null) {
            double matching = 0;

            if (pool == condoSpec.pool) {
                matching++;
            }
            if (exRoom == condoSpec.exRoom) {
                matching++;
            }
            if (locker == condoSpec.locker) {
                matching++;
            }
            if (hydroIncluded == condoSpec.hydroIncluded) {
                matching++;
            }
            if (cableIncluded == condoSpec.cableIncluded) {
                matching++;
            }

            if (matching / NUM_SPEC >= minPercent) {
                return true;
            }
        }

        return false;
    }

    /**
     * converts this condo specification to a string
     * 
     * @return the string
     */
    public String toString() {
        String condoString = "Pool: ";
        condoString += pool ? "Y" : "N";
        condoString += ", Exercise Room: ";
        condoString += exRoom ? "Y" : "N";
        condoString += ", Locker: ";
        condoString += locker ? "Y" : "N";
        condoString += ", Hydro Included: ";
        condoString += hydroIncluded ? "Y" : "N";
        condoString += ", Cable Included: ";
        condoString += cableIncluded ? "Y" : "N";

        return condoString;
    }
}
