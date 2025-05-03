import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Programmer: Sean Yang
 * Program Name: Payroll
 * Description: Stores a number of employees in a payroll
 * Date: 30/04/2025
 */

class Payroll {
    private Employee[] staffList;
    private final int maxNumStaff;
    private int numStaff;

    /**
     * loads the staff list into the array from a file
     * 
     * @param fileName the file to load from
     */
    void loadStaffList(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            numStaff = Integer.parseInt(br.readLine());

            if (numStaff > maxNumStaff) {
                numStaff = maxNumStaff;
            }

            for (int i = 0; i < numStaff; i++) {
                String title = br.readLine();

                int employeeNumber = Integer.parseInt(br.readLine());
                String firstName = br.readLine();
                String lastName = br.readLine();

                if (title.equals("full time")) {
                    double yearlySalary = Double.parseDouble(br.readLine());
                    int sickDaysLeft = Integer.parseInt(br.readLine());

                    staffList[i] = new FullTimeStaff(employeeNumber, firstName, lastName, yearlySalary, sickDaysLeft);
                } else {
                    double numHoursAssigned = Double.parseDouble(br.readLine());
                    double hourlyRate = Double.parseDouble(br.readLine());
                    int sickDaysTaken = Integer.parseInt(br.readLine());

                    staffList[i] = new PartTimeStaff(employeeNumber, firstName, lastName, numHoursAssigned, hourlyRate,
                            sickDaysTaken);
                }
            }

            br.close();
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    /**
     * constructor method for a payroll
     * 
     * @param maxNumStaff the maximum number of staff members on the payroll
     * @param fileName    the file name to load from
     */
    Payroll(int maxNumStaff, String fileName) {
        this.maxNumStaff = maxNumStaff;
        staffList = new Employee[maxNumStaff];
        numStaff = 0;

        loadStaffList(fileName);
    }

    /**
     * prints all employees to standard output
     */
    void listAllEmployee() {
        for (int i = 0; i < numStaff; i++) {
            System.out.println(staffList[i]);
        }
    }

    /**
     * finds an employee by their employee number
     * 
     * @param employeeNumber the employee number to search for
     * @return an employee object who has the queried ID
     */
    Employee searchByEmployeeNum(int employeeNumber) {
        for (int i = 0; i < numStaff; i++) {
            if (staffList[i].getEmployeeNumber() == employeeNumber) {
                return staffList[i];
            }
        }

        return null;
    }

    /**
     * deducts a sick day from an employee with a specified ID
     * 
     * @param employeeNumber the ID to query
     * @param daysSick       the number of sick days requested
     * @return whether or not the deduction succeeded
     */
    boolean enterSickDay(int employeeNumber, double daysSick) {
        Employee employee = searchByEmployeeNum(employeeNumber);

        if (employee != null) {
            return employee.deductSickDay(daysSick);
        }

        return false;
    }

    /**
     * prints all employee pay stubs to standard output
     */
    void printAllPayStubs() {
        for (int i = 0; i < numStaff; i++) {
            staffList[i].printPayStub();
        }
    }

    /**
     * saves the staff list array to a file
     * 
     * @param fileName the file name to save to
     */
    void saveStaffList(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            bw.write(numStaff + "\n");

            for (int i = 0; i < numStaff; i++) {
                Employee employee = staffList[i];

                if (employee instanceof FullTimeStaff currFullTimeStaff) {
                    bw.write("full time\n");
                    bw.write(employee.getEmployeeNumber() + "\n");
                    bw.write(employee.getFirstName() + "\n");
                    bw.write(employee.getLastName() + "\n");
                    bw.write(currFullTimeStaff.getYearlySalary() + "\n");
                    bw.write(currFullTimeStaff.getSickDaysLeft() + "\n");
                } else if (employee instanceof PartTimeStaff currPartTimeStaff) {
                    bw.write("part time\n");
                    bw.write(employee.getEmployeeNumber() + "\n");
                    bw.write(employee.getFirstName() + "\n");
                    bw.write(employee.getLastName() + "\n");
                    bw.write(currPartTimeStaff.getNumHoursAssigned() + "\n");
                    bw.write(currPartTimeStaff.getHourlyRate() + "\n");
                    bw.write(currPartTimeStaff.getSickDaysTaken() + "\n");
                }
            }

            bw.close();
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    /**
     * calculates the average salary of all full time staff
     * 
     * @return the average salary
     */
    double averageSalary() {
        int count = 0;
        double sum = 0;

        for (int i = 0; i < numStaff; i++) {
            if (staffList[i] instanceof FullTimeStaff currFullTimeStaff) {
                count++;
                sum += currFullTimeStaff.getYearlySalary();
            }
        }

        return sum / count;
    }

    /**
     * calculates the average hourly rate of all part time staff
     * 
     * @return the average hourly rate
     */
    double averageHourlyRate() {
        int count = 0;
        double sum = 0;

        for (int i = 0; i < numStaff; i++) {
            if (staffList[i] instanceof PartTimeStaff currPartTimeStaff) {
                count++;
                sum += currPartTimeStaff.getHourlyRate();
            }
        }

        return sum / count;
    }

    /**
     * finds the most absent full time staff member
     * 
     * @return a full time staff object who has been absent the most
     */
    FullTimeStaff mostAbsentFullTimeStaff() {
        FullTimeStaff mostAbsent = null;

        for (int i = 0; i < numStaff; i++) {
            if (staffList[i] instanceof FullTimeStaff currFullTimeStaff) {
                if (mostAbsent == null
                        || mostAbsent.compareToSickDay(currFullTimeStaff) > 0) {
                    mostAbsent = currFullTimeStaff;
                }
            }
        }

        return mostAbsent;
    }

    /**
     * finds the most absent part time staff member
     * 
     * @return a part time staff object who has been absent the most
     */
    PartTimeStaff mostAbsentPartTimeStaff() {
        PartTimeStaff mostAbsent = null;

        for (int i = 0; i < numStaff; i++) {
            if (staffList[i] instanceof PartTimeStaff currPartTimeStaff) {
                if (mostAbsent == null
                        || mostAbsent.compareToSickDay(currPartTimeStaff) > 0) {
                    mostAbsent = (PartTimeStaff) staffList[i];
                }
            }
        }

        return mostAbsent;
    }

    /**
     * resets the yearly sick days for full time staff
     */
    void yearlySickDayReset() {
        for (int i = 0; i < numStaff; i++) {
            if (staffList[i] instanceof FullTimeStaff) {
                staffList[i].resetSickDay();
            }
        }
    }

    /**
     * resets the monthly sick days for part time staff
     */
    void monthlySickDayReset() {
        for (int i = 0; i < numStaff; i++) {
            if (staffList[i] instanceof PartTimeStaff) {
                staffList[i].resetSickDay();
            }
        }
    }
}
