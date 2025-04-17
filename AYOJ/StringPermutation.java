import java.util.Scanner;

public class StringPermutation {
    static void permute(String word, int[] letters) {
        if (word.length() > 0) {
            letters[word.charAt(word.length() - 1) - 'a']--;
        }
        boolean rem = false;

        for (int i = 0; i < 26; i++) {
            int freq = letters[i];
            if (freq > 0) {
                permute(word + (char) (i + 'a'), letters.clone());
                rem = true;
            }
        }

        if (!rem) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        int[] letters = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            letters[c - 'a']++;
        }

        permute("", letters);

        sc.close();
    }
}
