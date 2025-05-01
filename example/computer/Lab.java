
/**
 * Programmer: Sean Yang
 * Program Name: Lab
 * Date: 16/04/2025
 * Description: Computer lab object definition
 */
public class Lab {
    private int maxComputers;
    private int installedComputers;
    private Computer[] computers;
    static final int CURRENT_YEAR = 2025;

    /**
     * Constructor method
     * 
     * @param maxComputers the maximum computers in the lab
     */
    Lab(int maxComputers) {
        this.maxComputers = maxComputers;
        computers = new Computer[maxComputers];
    }

    /**
     * installComputer method adds a computer
     * 
     * @param serial         the serial number
     * @param manufacturer   the computer manufacturer
     * @param yearMade       the year the computer was made
     * @param yearPurchased  the year the computer was purchased
     * @param processorSpeed the processor speed of the computer
     * @param ramSize        the ram installed in the computer
     * @param warrantyExpiry the warranty expiry date of the computer
     */
    boolean installComputer(String serial, String manufacturer, int yearMade, int yearPurchased, double processorSpeed,
            int ramSize, int warrantyExpiry) {
        if (installedComputers == maxComputers) {
            return false;
        }
        computers[installedComputers++] = new Computer(serial, manufacturer, yearMade, yearPurchased, processorSpeed,
                ramSize,
                warrantyExpiry);
        return true;
    }

    /**
     * averageAge calculates the average age of all computers in the lab
     * 
     * @return the average
     */
    double averageAge() {
        int sum = 0;
        for (int i = 0; i < installedComputers; i++) {
            sum += computers[i].age();
        }
        return (double) sum / installedComputers;
    }

    /**
     * newest finds the newest computer in the array
     * 
     * @return the newest computer
     */
    Computer newest() {
        Computer newest = computers[0];
        for (int i = 0; i < installedComputers; i++) {
            if (computers[i].age() < newest.age()) {
                newest = computers[i];
            }
        }
        return newest;
    }

    /**
     * fastest finds the fastest computer in the array
     * 
     * @return the fastest computer
     */
    Computer fastest() {
        Computer fastest = computers[0];
        for (int i = 0; i < installedComputers; i++) {
            if (computers[i].getProcessorSpeed() > fastest.getProcessorSpeed()) {
                fastest = computers[i];
            }
        }
        return fastest;
    }

    /**
     * mostRam finds the computer with the most ram in the array
     * 
     * @return the computer with the most ram
     */
    Computer mostRam() {
        Computer mostRam = computers[0];
        for (int i = 0; i < installedComputers; i++) {
            if (computers[i].getRamSize() > mostRam.getRamSize()) {
                mostRam = computers[i];
            }
        }
        return mostRam;
    }

    /**
     * numMadeBy finds the number of computers made by the given manufacturer
     * 
     * @param manufacturer the manufacturer
     * @return the number of computers
     */
    int numMadeBy(String manufacturer) {
        int num = 0;
        for (int i = 0; i < installedComputers; i++) {
            if (computers[i].getManufacturer().equals(manufacturer)) {
                num++;
            }
        }
        return num;
    }

    /**
     * expiringSoon finds all computers expiring in the next year
     * 
     * @return an array of expiring computers
     */
    Computer[] expiringSoon() {
        int numExpiring = 0;

        for (int i = 0; i < installedComputers; i++) {
            if (computers[i].getWarrantyExpiry() == CURRENT_YEAR + 1) {
                numExpiring++;
            }
        }

        Computer[] expiring = new Computer[numExpiring];
        numExpiring = 0;

        for (int i = 0; i < installedComputers; i++) {
            if (computers[i].getWarrantyExpiry() == CURRENT_YEAR + 1) {
                expiring[numExpiring++] = computers[i];
            }
        }

        return expiring;
    }
}
