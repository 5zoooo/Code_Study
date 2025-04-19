import java.io.*;
import java.util.*;

// 누적합 기본 문제
public class Main {
    private static int N;
    private static int[] arr;
    private static long[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sum = new long[N + 1]; // 누적합 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        long ans = 0;
        for (int i = 1; i < N; i++) {
            long res = getSum(i + 1, N);
            ans += res * arr[i];
        }

        System.out.println(ans);

        br.close();
    }

    private static long getSum(int left, int right) {
        return sum[right] - sum[left - 1];
    }
}
