/**
 * Programmer: Sean Yang
 * Program Name: NonUniform2DArray
 * Date: 07/02/2025
 * Description: computes the sum of all the elements of a 2d array
 */

public class NonUniform2DArray {
    public static void main(String[] args) {
        // declare constant (data)
        final int[][] data = {
                { 3, 2, 5 },
                { 1, 4, 4, 8, 13 },
                { 9, 1, 0, 2 },
                { 0, 2, 6, 4, -1, -8 }
        };

        // declare sum
        int sum;

        // init sum and calculate
        sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
            }
        }

        // output the sum
        System.out.println("The sum of the elements of the array is: " + sum);
    }
}
