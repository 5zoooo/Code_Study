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

        Arrays.sort(arr); // 1`7 8 9 배열값 형태

        visited = new boolean[N];
        res = new int[M];
        dfs(0);

        br.close();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
