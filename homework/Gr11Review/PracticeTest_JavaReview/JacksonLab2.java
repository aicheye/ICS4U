import java.util.Scanner;

public class JacksonLab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int numLines;
        int numCorrect;

        numLines = 0;
        numCorrect = 0;
        while (!line.equals("quit")) {
            numLines++;
            numCorrect++;
            try {
                Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                numCorrect--;
            }
            line = sc.nextLine();
        }

        System.out.println((double) numCorrect / numLines * 100 + "% of the lines are correct.");
    }
}
