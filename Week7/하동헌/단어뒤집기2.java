import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }

                while (S.charAt(i) != '>') {
                    System.out.print(S.charAt(i++));
                }
                System.out.print('>');
                continue;
            }

            if (S.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(' ');
            } else {
                stack.push(S.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        br.close();
    }
}
