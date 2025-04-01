import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static int[] res;
    private static StringBuilder sb;

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

        res = new int[M];
        sb = new StringBuilder();
        dfs(0);

        System.out.println(sb);

        br.close();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(res[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prevNum = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] != prevNum) {
                res[depth] = arr[i];
                dfs(depth + 1);
                prevNum = arr[i];
            }
        }
    }
}
