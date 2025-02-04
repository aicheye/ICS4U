/*
 Programmer: Sean Yang
 Program Name: Sleep
 Date: 04/02/2025
 Description: Calculates the hours of sleep you have had in your life
 */

import java.util.*;

public class Sleep {
    public static void main(String[] args) {
        // initialize constants
        final int SLEEP_PER_DAY = 8;
        final int DAYS_PER_MONTH = 30;
        final int DAYS_PER_YEAR = 365;

        // initialize scanner and variables
        Scanner sc = new Scanner(System.in);
        int birthYear, birthMonth, birthDay;
        int currYear, currMonth, currDay;
        int daysAlive;
        int hoursSlept;

        // take inputs
        System.out.println("Enter your birthdate:");

        System.out.print("Year: ");
        birthYear = sc.nextInt();

        System.out.print("Month: ");
        birthMonth = sc.nextInt();

        System.out.print("Day: ");
        birthDay = sc.nextInt();

        System.out.println("Enter today’s date: ");

        System.out.print("Year: ");
        currYear = sc.nextInt();

        System.out.print("Month: ");
        currMonth = sc.nextInt();

        System.out.print("Day: ");
        currDay = sc.nextInt();

        // calculate days alive and hours slept
        daysAlive = (currYear - birthYear) * DAYS_PER_YEAR;
        daysAlive += (currMonth - birthMonth) * DAYS_PER_MONTH;
        daysAlive += (currDay - birthDay);

        hoursSlept = daysAlive * SLEEP_PER_DAY;

        // output
        System.out.printf("You have been alive for %d days\n", daysAlive);
        System.out.printf("You have slept %d hours\n", hoursSlept);
    }
}
