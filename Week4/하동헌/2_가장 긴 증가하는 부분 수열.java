import java.io.*;
import java.util.*;

// LIS(Longest Increasing Subsequence): 웰-노운 DP 문제
public class Main {
    private static int[] arr;
    private static int[] dp; // i번째 숫자를 마지막으로 갖는 LIS 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // 기본적으로 각 원소는 LIS의 최소 길이 1을 가지게 설정
        }

        System.out.println(dp(N));

        br.close();
    }

    private static int dp(int N) {
        int maxLIS = 1;
        for (int i = 1; i < N; i++) { // 현재 위치 i
            for (int j = 0; j < i; j++) { // 0 ~ (i - 1)까지 비교
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;
    }
}

/*
7
1 2 1 5 3 4 6

5
*/
