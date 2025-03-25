import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1];
        dfs(1);
        // bfs(1);

        System.out.println(cnt - 1);

        br.close();
    }

    private static void dfs(int V) {
        visited[V] = true;
        cnt++;

        for (int next : graph[V]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int V) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited[V] = true;
        queue.offer(V);
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            cnt++;

            for (int next : graph[curNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
