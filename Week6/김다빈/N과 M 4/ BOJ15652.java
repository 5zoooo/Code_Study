import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int arr[];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        br.close();
        arr = new int[n + 1];
        backtracking(0, 1);

    }

    public static void backtracking(int depth, int idx) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= n; i++) {
            arr[depth] = i;
            backtracking(depth + 1, i);
        }
    }
}