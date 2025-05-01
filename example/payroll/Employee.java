/**
 * Programmer: Sean Yang
 * Program Name: Employee
 * Description: Abstract employee class
 * Date: 30/04/2025
 */

abstract class Employee {
    private int employeeNumber;
    private String firstName;
    private String lastName;

    /**
     * constructor method
     * 
     * @param employeeNumber the employee ID num
     * @param firstName
     * @param lastName
     */
    Employee(int employeeNumber, String firstName, String lastName) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * accessor for the employee ID
     * 
     * @return the id
     */
    int getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * accessor for the employee's first name
     * 
     * @return a string, the first name
     */
    String getFirstName() {
        return firstName;
    }

    /**
     * accessor for the employee's first name
     * 
     * @return a string, the last name
     */
    String getLastName() {
        return lastName;
    }

    /**
     * calculates the monthly pay for an employee
     * 
     * @return a double, the amount they should be paid
     */
    abstract double pay();

    /**
     * calculates appropriate deductions for a sick day
     * 
     * @param daysSick the number of days sick
     * @return whether the deduction succeeded
     */
    abstract boolean deductSickDay(double daysSick);

    /**
     * resets the sick days taken to default
     */
    abstract void resetSickDay();

    /**
     * outputs the employee's pay stub
     */
    abstract void printPayStub();

    /**
     * relevant information about the employee as a string
     * 
     * @return a string containing the id, first name, and last name
     */
    public String toString() {
        return "" + employeeNumber + " " + firstName + " " + lastName;
    }
}
