import java.io.*;
import java.util.*;

// 이분 탐색을 이용해 푸는 전형적인 매개 변수 탐색(Parametric Search)
// 이분 탐색 구간은 [1, 802]
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;
        long ans = 0;
        while (left <= right) {
            long mid = (right - left) / 2 + left;

            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= N) { // 만들 수 있음 → 그러면 길이를 더 늘려서 욕심을 내보자!
                ans = mid;
                left = mid + 1;
            } else { // 만들 수 없음 → 그러면 길이를 줄이자 ㅠㅠ
                right = mid - 1;
            }
        }

        System.out.println(ans);

        br.close();
    }
}
