import java.io.*;
import java.util.*;

// 2차원 누적합 배열 사용 X
public class Main {
    private static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        table = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < K; tc++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(getSum(i, j, x, y)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static int getSum(int i, int j, int x, int y) {
        int sum = 0;
        for (int row = i - 1; row <= x - 1; row++) {
            for (int col = j - 1; col <= y - 1; col++) {
                sum += table[row][col];
            }
        }
        return sum;
    }
}
