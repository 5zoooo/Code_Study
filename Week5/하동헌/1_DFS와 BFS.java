import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static int V;
    private static ArrayList<Integer>[] graph; // 인접 리스트
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1]; // 정점 번호가 1부터 시작
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 간선
            graph[u].add(v);
            graph[v].add(u);
        }

        // 정점 번호가 작은 것부터 방문하기 위해 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);

        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int startNode) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[startNode] = true;

        queue.offer(startNode);
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            System.out.print(curNode + " ");

            for (int next : graph[curNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
