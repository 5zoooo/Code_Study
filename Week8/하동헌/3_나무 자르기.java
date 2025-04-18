import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        long left = 0;
        long right = max;
        long ans = 0;
        while (left <= right) {
            long mid = (right - left) / 2 + left;

            long res = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0) {
                    res += arr[i] - mid;
                }
            }

            if (res >= M) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

        br.close();
    }
}
