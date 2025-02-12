/*
 Programmer: Sean Yang
 Program Name: Marks
 Date: 07/02/2007
 Description: Performs various operations on test marks
 */

import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        // declare scanner and variables
        Scanner sc = new Scanner(System.in);
        int numStudents;
        int numTests;
        int[][] marks;
        double[] averages;
        int maxStudent;
        double classAverage;

        // take inputs
        System.out.print("Enter the # of students: ");
        numStudents = sc.nextInt();
        System.out.print("Enter the # of tests: ");
        numTests = sc.nextInt();

        // initialize marks array
        marks = new int[numStudents][numTests];

        // enter all marks for students
        for (int j=0; j<numTests; j++) {
            for (int i=0; i<numStudents; i++) {
                System.out.printf("Enter student %d's mark on test %d: ", i, j);
                marks[i][j] = sc.nextInt();
            }
        }

        // initialize averages array
        averages = new double[numStudents];

        // calculate and output the average of each student
        for (int i=0; i<numStudents; i++) {
            averages[i] = 0;
            for (int j=0; j<numTests; j++) {
                averages[i] += (double) marks[i][j] / numTests;
            }
            System.out.printf("\nStudent %d's average is %.0f\n", i, averages[i]);
        }

        // initialize the maxStudent and maxAverage as the first student
        maxStudent = 0;

        // find the highest average and output it
        for (int i=0; i<numStudents; i++) {
            if (averages[i] > averages[maxStudent]) {
                maxStudent = i;
            }
        }

        // output the highest average
        System.out.printf("\nStudent %d has the highest average (%.0f)\n", maxStudent, averages[maxStudent]);

        // initialize the class average
        classAverage = 0;

        // find the class average
        for (int i=0; i<numStudents; i++) {
            classAverage += averages[i] / numStudents;
        }

        // loop over all students and output if they are higher than the class average
        System.out.printf("\nStudents with a mark higher than the class average (%.0f):\n", classAverage);
        for (int i=0; i<numStudents; i++) {
            if (averages[i] > classAverage) {
                System.out.printf("Student %d\n", i);
            }
        }

        // close scanner
        sc.close();
    }
}
