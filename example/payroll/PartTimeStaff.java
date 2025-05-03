
/**
 * Programmer: Sean Yang
 * Program Name: PartTimeStaff
 * Description: Subclass of the abstract employee class for a part time staff
 * member
 * Date: 30/04/2024
 */

class PartTimeStaff extends Employee {
    public static final int HOURS_PER_DAY = 8;
    double numHoursAssigned;
    double hourlyRate;
    int sickDaysTaken;

    /**
     * constructor for a part time staff member
     * 
     * @param employeeNumber   the id number
     * @param firstName
     * @param lastName
     * @param numHoursAssigned the number of monthly hours assigned to this employee
     * @param hourlyRate       the hourly rate they are paid
     * @param sickDaysTaken    the number of sick days they have taken this month
     */
    PartTimeStaff(int employeeNumber, String firstName, String lastName, double numHoursAssigned, double hourlyRate,
            int sickDaysTaken) {
        super(employeeNumber, firstName, lastName);
        this.numHoursAssigned = numHoursAssigned;
        this.hourlyRate = hourlyRate;
        this.sickDaysTaken = sickDaysTaken;
    }

    /**
     * accessor method for the number of hours assigned
     * 
     * @return the number of hours assigned
     */
    double getNumHoursAssigned() {
        return numHoursAssigned;
    }

    /**
     * accessor method for the hourly rate
     * 
     * @return the hourly rate
     */
    double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * accessor method for the number sick days taken
     * 
     * @return the number of sick days taken
     */
    int getSickDaysTaken() {
        return sickDaysTaken;
    }

    /**
     * helper method which calculates the number of hours this employee has worked
     * this month
     * 
     * @return the number of hours
     */
    private double hoursWorked() {
        return numHoursAssigned - (sickDaysTaken * HOURS_PER_DAY);
    }

    /**
     * calculates the pay this employee should receive this month
     * 
     * @return the pay
     */
    double pay() {
        return hourlyRate * hoursWorked();
    }

    /**
     * deducts a sick day from this employee's monthly pay. must be in units of 0.5
     * 
     * @boolean returns whether or not the sick day was successfully deducted
     */
    boolean deductSickDay(double daysSick) {
        if ((int) (daysSick * 2) != daysSick * 2) {
            System.out.println("Days must be in units of 0.5.");
            return false;
        }

        sickDaysTaken += daysSick;
        return true;
    }

    /**
     * resets the number of sick days taken to zero
     */
    void resetSickDay() {
        sickDaysTaken = 0;
    }

    /**
     * outputs the part time employee's pay stub
     */
    void printPayStub() {
        System.out.println(this);
        System.out.printf("hours worked: %.1f pay: $%.2f%n", hoursWorked(), pay());
    }

    /**
     * compares the sick days of two part time staff objects
     * 
     * @param other the other part time staff
     * @return an integer, positive if this employee has taken less sick days, zero
     *         if they have taken the same number, negative if this employee has
     *         taken more sick days
     */
    int compareToSickDay(PartTimeStaff other) {
        return other.sickDaysTaken - sickDaysTaken;
    }
}
