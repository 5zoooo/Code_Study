import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] inputMap;
    private static boolean[][] visited;
    private static final int[] di = {-1, 1, 0, 0};
    private static final int[] dj = {0, 0, -1, 1};
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inputMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                inputMap[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (inputMap[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    // dfs(i, j);
                    bfs(i, j);
                    list.add(cnt);
                }
            }
        }

        System.out.println(list.size());

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        br.close();
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        cnt++;

        for (int k = 0; k < 4; k++) {
            int nextI = i + di[k];
            int nextJ = j + dj[k];

            if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N) {
                if (inputMap[nextI][nextJ] == 1 && !visited[nextI][nextJ]) {
                    dfs(nextI, nextJ);
                }
            }
        }
    }

    private static void bfs(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curArr = queue.poll();
            int curI = curArr[0];
            int curJ = curArr[1];
            cnt++;

            for (int k = 0; k < 4; k++) {
                int nextI = curI + di[k];
                int nextJ = curJ + dj[k];

                if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N) {
                    if (inputMap[nextI][nextJ] == 1 && !visited[nextI][nextJ]) {
                        visited[nextI][nextJ] = true;
                        queue.offer(new int[]{nextI, nextJ});
                    }
                }
            }
        }
    }
}
