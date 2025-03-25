import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static int N;
    private static int[] arr; // 각 컴퓨터를 해킹했을 때 감염 가능한 수를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 단방향 그래프 - A가 B를 신뢰한다
            graph[B].add(A);
        }

        // 각 정점에서 BFS를 수행해 결과값들을 저장
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i] == max) {
                System.out.print(i);
                if (i != N) {
                    System.out.print(" ");
                }
            }
        }

        br.close();
    }

    private static int bfs(int V) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int cnt = 1;

        boolean[] visited = new boolean[N + 1];
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

        return cnt;
    }
}
