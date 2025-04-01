import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new int[M];
        dfs(1, 0);

        br.close();
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
            res[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
