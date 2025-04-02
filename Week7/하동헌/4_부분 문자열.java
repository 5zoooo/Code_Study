import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();

            int sIdx = 0;
            boolean isYes = false;
            for (int tIdx = 0; tIdx < t.length(); tIdx++) {
                if (s.charAt(sIdx) == t.charAt(tIdx)) {
                    sIdx++;
                    if (sIdx == s.length()) {
                        isYes = true;
                        break;
                    }
                }
            }

            if (isYes) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        br.close();
    }
}
