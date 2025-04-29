import java.io.*;
import java.util.*;

// 아래 블로그 그림 참고하자
// https://january-diary.tistory.com/entry/BOJ-11660-%EA%B5%AC%EA%B0%84-%ED%95%A9-%EA%B5%AC%ED%95%98%EA%B8%B0-JAVA
public class Main {
    private static int[][] cumSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        cumSum = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 가로, 세로는 더하고 대각선은 빼기(중복)
                cumSum[i + 1][j + 1] = cumSum[i][j + 1] + cumSum[i + 1][j] - cumSum[i][j] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(getSum(x1 - 1, y1 - 1, x2 - 1, y2 - 1)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static int getSum(int x1, int y1, int x2, int y2) {
        // 가로 세로 빼고 대각선은 더하기(중복)
        return cumSum[x2 + 1][y2 + 1] + cumSum[x1][y1] - cumSum[x2 + 1][y1] - cumSum[x1][y2 + 1];
    }
}
