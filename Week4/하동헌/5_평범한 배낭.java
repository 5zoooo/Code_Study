import java.io.*;
import java.util.*;

// 부분적 배낭 문제는 그리디로 풀지만,
// 완전한 0-1 배낭 문제는 DP로 푼다
public class Main {
    private static int N;
    private static int K;
    private static int[] W;
    private static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp());

        br.close();
    }

    private static int dp() {
        int[] dp = new int[K + 1];  // 배낭의 최대 무게 K까지 저장하는 DP 배열

        for (int i = 0; i < N; i++) {  // 각 아이템을 순회
            for (int j = K; j >= W[i]; j--) {  // 현재 무게부터 0까지 역순으로 계산
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }

        return dp[K];
    }
}
