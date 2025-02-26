
/**
 * Programmer: Sean Yang
 * Program Name: Marks
 * Date: 21/02/2025
 * Description: Performs various operations on an input file of marks
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Marks {
    public static void main(String[] args) {
        // declare buffered reader and variables
        BufferedReader br;
        BufferedWriter bw;
        final int STUDENTS = 10;
        final int TESTS = 5;
        int[][] marks = new int[STUDENTS][TESTS];
        String[] line;
        double[] averages = new double[STUDENTS];
        int maxAverage;
        double classAverage;

        // try to use file reader and file writer
        try {
            // initialize buffered reader
            br = new BufferedReader(new FileReader("marks.txt"));

            // take input form marks.txt
            for (int i = 0; i < STUDENTS; i++) {
                line = br.readLine().split(" ");
                for (int j = 0; j < TESTS; j++) {
                    marks[i][j] = Integer.parseInt(line[j]);
                }
            }

            // initialize buffered writer
            bw = new BufferedWriter(new FileWriter("results.txt"));

            // calculate the average for each student and write to results.txt
            for (int i = 0; i < STUDENTS; i++) {
                // calculate the average for each student
                averages[i] = 0;
                for (int j = 0; j < TESTS; j++) {
                    averages[i] += (double) marks[i][j] / TESTS;
                }

                // output answer for this student
                bw.write(String.format("The average of student %d is %.2f%n", i, averages[i]));
            }

            // initialize maxAverage as index 0
            maxAverage = 0;

            // loop over each student and check if their aveage is higher
            for (int i = 0; i < STUDENTS; i++) {
                if (averages[i] > averages[maxAverage])
                    maxAverage = i;
            }

            // output the student with the highest overall average
            bw.write(String.format("%nStudent %d has the highest average.%n%n", maxAverage));

            // calculate the class average for each test and write to results.txt
            for (int i = 0; i < TESTS; i++) {
                // calculate the average for each student
                classAverage = 0;
                for (int j = 0; j < STUDENTS; j++) {
                    classAverage += (double) marks[j][i] / STUDENTS;
                }

                // output answer for this test
                bw.write(String.format("The class average of test %d is %.2f%n", i, classAverage));
            }

            // flush and close input and output streams
            br.close();
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error accessing files.");
        }
    }
}
