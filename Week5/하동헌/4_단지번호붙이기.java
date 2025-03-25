import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] row = {-1, 1, 0, 0}; // 상, 하
    private static int[] col = {0, 0, -1, 1}; // 좌, 우
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    // 새로운 단지 시작
                    cnt = 0;
                    dfs(i, j); // bfs(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        br.close();
    }

    // 현재 위치(i, j)에서 연결된 모든 집을 dfs로 방문하여 카운트
    private static void dfs(int i, int j) {
        visited[i][j] = true;
        cnt++;

        for (int k = 0; k < 4; k++) {
            int nextRow = i + row[k];
            int nextCol = j + col[k];

            if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N) {
                if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                    dfs(nextRow, nextCol);
                }
            }
        }
    }

    // 현재 위치(i, j)에서 연결된 모든 집을 bfs로 방문하여 카운트
    private static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        cnt = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for (int k = 0; k < 4; k++) {
                int nextRow = curRow + row[k];
                int nextCol = curCol + col[k];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N) {
                    if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                        cnt++;
                    }
                }
            }
        }
    }
}
