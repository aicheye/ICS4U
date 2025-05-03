
/**
 * Programmer: Sean Yang
 * Program Name: SecondarySpec
 * Description: Abstract class describing secondary specifications for a
 * property
 * Date: 01/05/2025
 */

public abstract class SecondarySpec {

    /**
     * returns whether this secondary specification matches the minimum requirements
     * of another secondary specification.
     * 
     * @param other
     * @param minPercent the minimum percent of matching secondary specifications
     * @return
     */
    public abstract boolean matchSpec(SecondarySpec other, double minPercent);
}
