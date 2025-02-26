import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bunnyDist;
        int bunnySpeed;
        double bunnyTime;
        int turtleDist;
        int turtleSpeed;
        double turtleTime;

        System.out.println("Bunny");
        System.out.print("Distance between home and mall: ");
        bunnyDist = sc.nextInt();
        System.out.print("Speed: ");
        bunnySpeed = sc.nextInt();

        System.out.println("Turtle");
        System.out.print("Distance between home and mall: ");
        turtleDist = sc.nextInt();
        System.out.print("Speed: ");
        turtleSpeed = sc.nextInt();

        Trip calculate = new Trip();

        bunnyTime = calculate.calcTime(bunnyDist, bunnySpeed);
        turtleTime = calculate.calcTime(turtleDist, turtleSpeed);

        if (bunnyTime > turtleTime) {
            System.out.println("Turtle gets to the mall earlier");
        } else {
            System.out.println("Bunny gets to the mall earlier.");
        }

        sc.close();
    }
}
