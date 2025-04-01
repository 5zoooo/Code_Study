import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static boolean[] visited;
    private static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        visited = new boolean[N];
        res = new int[M];
        dfs(0, 0);

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

        for (int i = at; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[depth] = arr[i];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
