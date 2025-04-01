import java.io.*;
import java.util.*;

// 백트래킹: 완전탐색 + 가지치기
// 이 문제에서 가지치기는 없다! (완탐만 있음)
public class Main {
    private static int N, M;
    private static int[] res;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new int[M];
        visited = new boolean[N + 1];
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

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[depth] = i;
                dfs(depth + 1); 
                visited[i] = false; // 자식노드 방문이 끝나고 돌아올 때 원상 복구
            }
        }
    }
}
