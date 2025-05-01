/**
 * Programmer: Sean Yang
 * Program Name: FullTimeStaff
 * Description: Subclass of the abstract employee class for a full time staff
 * member
 * Date: 30/04/2025
 */

class FullTimeStaff extends Employee {
    public static final int YEARLY_SICK_DAY = 20;
    private double yearlySalary;
    private int sickDaysLeft;

    /**
     * constructor method for a full time staff
     * 
     * @param employeeNumber the employee's ID number
     * @param firstName
     * @param lastName
     * @param yearlySalary
     * @param sickDaysLeft   the number of sick days remaining this year
     */
    FullTimeStaff(int employeeNumber, String firstName, String lastName, double yearlySalary, int sickDaysLeft) {
        super(employeeNumber, firstName, lastName);
        this.yearlySalary = yearlySalary;
        this.sickDaysLeft = sickDaysLeft;
    }

    /**
     * accessor method for the yearly salary
     * 
     * @return the salary
     */
    double getYearlySalary() {
        return yearlySalary;
    }

    /**
     * accessor method for the number of sick days left
     * 
     * @return the number of sick days left
     */
    int getSickDaysLeft() {
        return sickDaysLeft;
    }

    /**
     * calculates the monthly pay for a full time staff
     * 
     * @return the monthly pay
     */
    double pay() {
        return yearlySalary / 12;
    }

    /**
     * deducts a sick day from the number of permitted sick days. must be in units
     * of 0.5 and must have at least 1 sick day remaining this year.
     * 
     * @return whether or not the deduction succeeded
     */
    boolean deductSickDay(double daysSick) {
        if ((int) (daysSick * 2) != daysSick * 2) {
            System.out.println("Days must be in units of 0.5.");
            return false;
        }

        if ((sickDaysLeft -= daysSick) == 0) {
            System.out.println("There are no sick days remaining.");
            sickDaysLeft = 0;
            return false;
        }

        return true;
    }

    /**
     * resets sick days to the yearly allotted number
     */
    void resetSickDay() {
        sickDaysLeft = YEARLY_SICK_DAY;
    }

    /**
     * outputs the pay stub
     */
    void printPayStub() {
        System.out.println(this);
        System.out.printf("monthly pay: $%.2f sick days left: %d%n", pay(), sickDaysLeft);
    }

    /**
     * compares two full time staff objects
     * 
     * @param other the other full time staff
     * @return an integer, positive if this employee has taken less sick days, zero
     *         if they are the same, negative if this employee has taken more sick
     *         days
     */
    int compareToSickDay(FullTimeStaff other) {
        return sickDaysLeft - other.sickDaysLeft;
    }
}
