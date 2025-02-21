
/**
 * Programmer: Sean Yang
 * Program Name: Line
 * Date: 20/02/2025
 * Description: calculates different properties of a line
 */

public class Line {

    /**
     * Calculates the length of a line given two points
     * 
     * @param x1 x-coord of first point
     * @param y1 y-coord of first point
     * @param x2 x-coord of second point
     * @param y2 y=coord of second point
     * @return the length of the line
     */
    public static double length(int x1, int y1, int x2, int y2) {
        double deltaX;
        double deltaY;
        double ans;

        deltaX = x2 - x1;
        deltaY = y2 - y1;

        ans = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        return ans;
    }

    /**
     * Calculates the slope of a line given two points
     * 
     * @param x1 x-coord of first point
     * @param y1 y-coord of first point
     * @param x2 x-coord of second point
     * @param y2 y=coord of second point
     * @return the length of the line
     */
    public static double slope(int x1, int y1, int x2, int y2) {
        double deltaX;
        double deltaY;
        double ans;

        deltaX = x2 - x1;
        deltaY = y2 - y1;

        ans = deltaY / deltaX;

        return ans;
    }
}
