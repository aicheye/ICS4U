public class GenerateString {
    public static void nextString(String s, int target) {
        if (s.length() == target) {
            System.out.println(s);
            return;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            nextString(s + i, target);
        }
    }

    public static void main(String[] args) {
        nextString("", 10);
    }
}
