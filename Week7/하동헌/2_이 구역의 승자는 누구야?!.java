import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int sum = 0;
        for (int i = 0; i < input.length() - 1; i += 2) {
            sum += (getCharToNum(input.charAt(i)) + getCharToNum(input.charAt(i + 1)));
            sum %= 10;
        }
        if (input.length() % 2 == 1) {
            sum += getCharToNum(input.charAt(input.length() - 1));
            sum %= 10;
        }

        if (sum % 2 == 1) {
            System.out.println("I'm a winner!");
        } else {
            System.out.println("You're the winner?");
        }

        br.close();
    }

    private static int getCharToNum(char c) {
        if (c == 'C' || c == 'I' || c == 'J' || c == 'L' || c == 'O' || c == 'S' || c == 'U' || c == 'V' || c == 'Z') {
            return 1;
        } else if (c == 'B' || c == 'D' || c == 'P' || c == 'Q' || c == 'R' || c == 'T' || c == 'W' || c == 'X' || c == 'Y') {
            return 2;
        } else {
            return 3;
        }
    }
}
