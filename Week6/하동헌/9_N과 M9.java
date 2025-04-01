import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] arr;

    private static boolean[] visited;
    private static int[] res;
    private static LinkedHashSet<String> set;

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
        set = new LinkedHashSet<>();
        dfs(0);

        for (String ans: set) {
            System.out.print(ans);
        }

        br.close();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(res[i]).append(' ');
            }
            sb.append('\n');
            set.add(sb.toString());
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
