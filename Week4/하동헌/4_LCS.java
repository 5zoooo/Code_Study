import java.io.*;
import java.util.*;

// LCS(Longest Common SubSequance) - 최장 공통 부분 수열: 웰-노운 DP 문제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(dp(str1, str2));

        br.close();
    }

    private static int dp(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // 문자가 같으면 이전 LCS 값에 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 문자가 다르면 왼쪽 또는 위쪽 값 중 최댓값 사용
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2]; // LCS(최장 공통 부분 수열)의 길이 반환
    }
}
