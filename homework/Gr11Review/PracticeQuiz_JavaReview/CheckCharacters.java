import java.util.Scanner;

public class CheckCharacters {
    public static void main(String[] args) {
        // declare scanner
        Scanner sc = new Scanner(System.in);

        // declare variables
        String list;
        int uppers;
        char largest;

        // take user inputs for list
        list = "";
        System.out.println("Enter 's' or 'S' to exit!");
        do {
            System.out.print("Enter a character: ");
            list += sc.next();
        } while (list.charAt(list.length() - 1) != 's' && list.charAt(list.length() - 1) != 'S');

        // remove the last character
        list = list.substring(0, list.length() - 1);

        // count upper case and largest character
        uppers = 0;
        largest = list.charAt(0);
        for (int i=0; i<list.length(); i++) {
            if ('A' <= list.charAt(i) && list.charAt(i) <= 'Z') uppers++;
            if (largest < list.charAt(i)) largest = list.charAt(i);
        }

        // output answers
        System.out.printf("\n%d characters are upper case alphabet\n", uppers);
        System.out.printf("The largest character is %c\n", largest);

        // close scanner
        sc.close();
    }
}
