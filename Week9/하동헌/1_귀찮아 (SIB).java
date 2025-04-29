import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static long[] cumSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cumSum = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        cumSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cumSum[i] = cumSum[i - 1] + arr[i];
        }

        long ans = 0;
        for (int i = 0; i < N - 1; i++) {
            long res = getSum(i + 1, N - 1);
            ans += arr[i] * res;
        }

        System.out.println(ans);

        br.close();
    }

    private static long getSum(int left, int right) {
        return cumSum[right] - cumSum[left - 1];
    }
}
