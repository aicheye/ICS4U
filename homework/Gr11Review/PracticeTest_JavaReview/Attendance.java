import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUMSTUDENT = 5;
        final int DAYS = 5;
        String names[] = new String[NUMSTUDENT];
        boolean attendance[][] = new boolean[NUMSTUDENT][DAYS];
        String query;
        int daysAbsent = -1;

        System.out.print("Enter a student's name: ");
        query = sc.nextLine();

        for (int i = 0; i < NUMSTUDENT && daysAbsent == -1; i++) {
            if (query.equals(names[i])) {
                daysAbsent = 0;
                for (int j = 0; j < DAYS; j++) {
                    if (!attendance[i][j])
                        daysAbsent++;
                }
                System.out.println("Absent for " + daysAbsent + " days.");
            }
        }

        if (daysAbsent < 0)
            System.out.println("Student not found.");

        sc.close();
    }
}
