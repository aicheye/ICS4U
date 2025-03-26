import java.util.Scanner;

public class BitStringGenerator {
    public static void generate(String s, int n, int k) {
        if (n == 0) {
            System.out.println(s);
            return;
        }
        if (k > 0) {
            generate(s + '1', n - 1, k - 1);
        }
        if (n - k > 0) {
            generate(s + '0', n - 1, k);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            generate("", n, k);
        }
        sc.close();
    }
}
