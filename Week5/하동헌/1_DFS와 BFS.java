import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb.toString().trim());

        visited = new boolean[N + 1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb.toString().trim());

        br.close();
    }

    private static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(" ");

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
            sb.append(curNode).append(" ");

            for (int next : graph[curNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
