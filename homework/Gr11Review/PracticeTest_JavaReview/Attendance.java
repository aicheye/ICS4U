import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NUM_STUDENT = 5;
        final int DAYS = 5;
        String[] names;
        boolean[][] attendance;
        String query;
        int daysAbsent = -1;

        names = new String[]{
                "Albert",
                "Brandy",
                "Chris",
                "Declan",
                "Eva"
        };

        attendance = new boolean[][]{
                {false, false, false, true, true},
                {true, true, true, true, true},
                {false, false, true, true, true},
                {true, true, true, true, false},
                {false, true, false, true, false}
        };

        System.out.print("Enter a student's name: ");
        query = sc.nextLine();

        for (int i = 0; i < NUM_STUDENT && daysAbsent == -1; i++) {
            if (query.equals(names[i])) {
                daysAbsent = 0;
                for (int j = 0; j < DAYS; j++) {
                    if (!attendance[i][j])
                        daysAbsent++;
                }
                System.out.println("Absent for " + daysAbsent + " day(s).");
            }
        }

        if (daysAbsent < 0)
            System.out.println("Student not found.");

        sc.close();
    }
}
