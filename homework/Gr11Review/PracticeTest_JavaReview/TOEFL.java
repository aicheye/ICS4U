import java.util.Scanner;

public class TOEFL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int readingScore;
        int listeningScore;
        int speakingScore;
        int writingScore;
        final int MIN_TOTAL = 90;
        final int MIN_RW = 25;

        System.out.print("Enter the reading score: ");
        readingScore = sc.nextInt();
        System.out.print("Enter the listening score: ");
        listeningScore = sc.nextInt();
        System.out.print("Enter the speaking score: ");
        speakingScore = sc.nextInt();
        System.out.print("Enter the writing fail: ");
        writingScore = sc.nextInt();

        if (readingScore +
                listeningScore +
                speakingScore +
                writingScore >= MIN_TOTAL &&
                readingScore >= MIN_RW &&
                writingScore >= MIN_RW) {
            System.out.println("You have met the minimum requirements.");
        } else {
            System.out.println("You have not met the minimum requirements.");
        }

        sc.close();
    }

}
