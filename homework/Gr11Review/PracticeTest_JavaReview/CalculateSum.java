import java.util.Scanner;

public class CalculateSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        int n;
        int ans;

        System.out.print("Enter X: ");
        x = sc.nextInt();
        System.out.print("Enter N: ");
        n = sc.nextInt();

        ans = 0;
        for (int i = 1; i <= 2 * n; i++) {
            if (i % 2 == 1) {
                ans += (int) Math.pow(x, i);
            } else {
                ans -= (int) Math.pow(x, i);
            }
        }

        System.out.println("Answer: " + ans);

        sc.close();
    }
}
