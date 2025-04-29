import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int M = Integer.parseInt(br.readLine());

        int low = 0;
        int high = max;
        int ans = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;

            int cost = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] < mid) {
                    cost += arr[i];
                } else {
                    cost += mid;
                }
            }

            if (cost <= M) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);

        br.close();
    }
}
