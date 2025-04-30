import java.io.*;
import java.util.*;

public class Main {
    private static int[] cumSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cumSum = new int[N];
        cumSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            cumSum[i] = cumSum[i - 1] + arr[i];
        }

        int sumMax = -2147483648;
        int sumCnt = 1;
        for (int i = 0; i < N - X + 1; i++) {
            int sum = getSum(i, i + X - 1);
            if (sum == sumMax) {
                sumCnt++;
            } else if (sum > sumMax) {
                sumMax = sum;
                sumCnt = 1;
            }
        }

        if (sumMax == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(sumMax);
            System.out.println(sumCnt);
        }

        br.close();
    }

    private static int getSum(int l, int r) {
        if (l == 0) {
            return cumSum[r];
        }
        return cumSum[r] - cumSum[l - 1];
    }
}
