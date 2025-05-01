import java.util.Scanner;

/**
 * Programmer: Sean Yang
 * Program Name: PayrollRunner
 * Description: Runner for the payroll class
 * Date: 30/04/2025
 */

public class PayrollRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum # of staff: ");
        int maxNumStaff = sc.nextInt();
        System.out.print("Enter file name: ");
        sc.nextLine();
        String fileName = sc.nextLine();

        Payroll payroll = new Payroll(maxNumStaff, fileName);

        boolean exit = false;
        while (!exit) {
            System.out.println("""
                    Choose an option:
                    1: list all employees
                    2: enter sick days for an employee
                    3: print monthly pay stubs for all employees
                    4: reset yearly sick days for full time staff
                    5: reset monthly sick days for part time staff
                    6: save employee information to file
                    7: load employee information from file
                    8: output the average salary of full time staff
                    9: output the average salary of part time staff
                    10: output the full time staff who has taken the most sick days this year
                    11: output the part time staff who has taken the most sick days this month""");

            String input = sc.nextLine();

            try {
                switch (Integer.parseInt(input)) {
                    case 1:
                        payroll.listAllEmployee();
                        break;

                    case 2:
                        System.out.print("Enter employee ID: ");
                        int employeeNumber = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter number of sick days (must be in units of 0.5): ");
                        double days = sc.nextDouble();
                        sc.nextLine();
                        if (payroll.enterSickDay(employeeNumber, days)) {
                            System.out.println("Deducted successfully.");
                        } else {
                            System.out.println("Could not deduct sick days.");
                        }
                        break;

                    case 3:
                        payroll.printAllPayStubs();
                        break;

                    case 4:
                        payroll.yearlySickDayReset();
                        break;

                    case 5:
                        payroll.monthlySickDayReset();
                        break;

                    case 6:
                        System.out.print("Enter file name: ");
                        fileName = sc.nextLine();
                        payroll.saveStaffList(fileName);
                        break;

                    case 7:
                        System.out.print("Enter file name: ");
                        fileName = sc.nextLine();
                        payroll.loadStaffList(fileName);
                        break;

                    case 8:
                        System.out.println(payroll.averageSalary());
                        break;

                    case 9:
                        System.out.println(payroll.averageHourlyRate());
                        break;

                    case 10:
                        System.out.println(payroll.mostAbsentFullTimeStaff());
                        break;

                    case 11:
                        System.out.println(payroll.mostAbsentPartTimeStaff());
                        break;

                    default:
                        System.out.println("Must enter a valid option.");
                        break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Must enter a valid option.");
            }

            System.out.print("Press enter to continue.");
            sc.nextLine();
        }

        sc.close();
    }
}
