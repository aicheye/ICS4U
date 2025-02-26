import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseText {
    public static void main(String[] args) {
        final String INPUT_FILE = "data.txt";
        final String OUTPUT_FILE = "result.txt";
        BufferedReader br;
        BufferedWriter bw;
        String line;

        try {
            br = new BufferedReader(new FileReader(INPUT_FILE));
            bw = new BufferedWriter(new FileWriter(OUTPUT_FILE));

            line = br.readLine();
            while (line != null) {
                for (int i = line.length() - 1; i >= 0; i--) {
                    bw.write(line.charAt(i));
                }
                bw.write("\n");
                line = br.readLine();
            }

            br.close();
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }
}
