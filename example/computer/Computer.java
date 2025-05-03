
/**
 * Programmer: Sean Yang
 * Program Name: Computer
 * Date: 16/04/2025
 * Description: Defines a computer object
 */
class Computer {
    private String serial;
    private String manufacturer;
    private int yearMade;
    private int yearPurchased;
    private double processorSpeed;
    private int ramSize;
    private int warrantyExpiry;

    /**
     * getSerial accessor for serial number
     * 
     * @return the serial number
     */
    String getSerial() {
        return serial;
    }

    /**
     * setSerial mutator for serial number
     * 
     * @param serial the new number
     */
    void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * getManufacturer accessor for manufacturer
     * 
     * @return the manufacturer
     */
    String getManufacturer() {
        return manufacturer;
    }

    /**
     * setManufacturer mutator for manufacturer
     * 
     * @param manufacturer the new manufacturer
     */
    void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * getYearMade accessor for year made
     * 
     * @return the year made
     */
    int getYearMade() {
        return yearMade;
    }

    /**
     * setYearMade mutator for year made
     * 
     * @param yearMade the new year made
     */
    void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    /**
     * getYearPurchased accessor for year purchased
     * 
     * @return the year purchased
     */
    int getYearPurchased() {
        return yearPurchased;
    }

    /**
     * setYearPurchased mutator for year purchased
     * 
     * @param yearPurchased the new year purchased
     */
    void setYearPurchased(int yearPurchased) {
        this.yearPurchased = yearPurchased;
    }

    /**
     * getProcessorSpeed accessor for processor speed
     * 
     * @return the processor speed
     */
    double getProcessorSpeed() {
        return processorSpeed;
    }

    /**
     * setProcessorSpeed mutator for processor speed
     * 
     * @param processorSpeed the new processor speed
     */
    void setProcessorSpeed(double processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    /**
     * getRamSize accessor for RAM size
     * 
     * @return the RAM size
     */
    int getRamSize() {
        return ramSize;
    }

    /**
     * setRamSize mutator for RAM size
     * 
     * @param ramSize the new RAM size
     */
    void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    /**
     * getWarrantyExpiry accessor for warranty expiry
     * 
     * @return the warranty expiry
     */
    int getWarrantyExpiry() {
        return warrantyExpiry;
    }

    /**
     * setWarrantyExpiry mutator for warranty expiry
     * 
     * @param warrantyExpiry the new warranty expiry
     */
    void setWarrantyExpiry(int warrantyExpiry) {
        this.warrantyExpiry = warrantyExpiry;
    }

    /**
     * Constructor method for the Computer class
     * 
     * @param serial
     * @param manufacturer
     * @param yearMade
     * @param yearPurchased
     * @param processorSpeed
     * @param ramSize
     * @param warrantyExpiry
     */
    Computer(String serial, String manufacturer, int yearMade, int yearPurchased, double processorSpeed, int ramSize,
            int warrantyExpiry) {
        this.serial = serial;
        this.manufacturer = manufacturer;
        this.yearMade = yearMade;
        this.yearPurchased = yearPurchased;
        this.processorSpeed = processorSpeed;
        this.ramSize = ramSize;
        this.warrantyExpiry = warrantyExpiry;
    }

    /**
     * toString returns a string with information about this computer
     * 
     * @return a string containing information about this computer
     */
    public String toString() {
        return String.format(
                "Serial Number: %s, Manufacturer: %s, Year Manufactured: %d, Year Purchased: %d, Processor Speed, %f, Ram Size: %d, Warranty Expiry Year: %d",
                serial, manufacturer, yearMade, yearPurchased, processorSpeed, ramSize, warrantyExpiry);
    }

    /**
     * compareToSpeed compares the speeds of two computers
     * 
     * @param other the other computer
     * @return a double, positive if this computer is slower, zero if they are
     *         equal, negative if this computer is faster
     */
    double compareToSpeed(Computer other) {
        return processorSpeed - other.processorSpeed;
    }

    /**
     * compareToRamSize compares the ram sizes of two computers
     * 
     * @param other the other computer
     * @return an integer, positive if this computer has more ram, zero if they are
     *         equal, negative if this computer has less ram
     */
    int compareToRamSize(Computer other) {
        return ramSize - other.ramSize;
    }

    /**
     * age the age of the computer
     * 
     * @return the age of this computer
     */
    int age() {
        return Lab.CURRENT_YEAR - yearMade;
    }

    /**
     * compareToRamSize compares the ages of two computers
     * 
     * @param other the other computer
     * @return an integer, positive if this computer is older, zero if they are
     *         equal, negative if this computer is younger
     */
    int compareToAge(Computer other) {
        return age() - other.age();
    }
}
