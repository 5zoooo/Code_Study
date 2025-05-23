import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            arr = new int[2][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(dp());
        }

        br.close();
    }

    private static int dp() {
        if (n == 1) {
            return Math.max(arr[0][0], arr[1][0]);
        }
        
        // 현재 스티커를 선택할 때
        // 이전 열에서 대각선 스티커를 선택했을 경우 or 그 전전 열에서 선택했을 경우
        // 이 두 개 중에 최대 점수를 선택!
        int[][] dp = new int[2][n];
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[0][1] = arr[1][0] + arr[0][1];
        dp[1][1] = arr[0][0] + arr[1][1];

        for (int i = 2; i < n; i++) {
            dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
            dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
