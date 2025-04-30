import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 투 포인터 전에 정렬 필수

        int left = 0;
        int right = N - 1;
        int cnt = 0;
        while (left < right) {  // 투 포인터로 합이 M인 쌍 탐색
            int sum = arr[left] + arr[right];

            if (sum == M) {
                cnt++;
                left++;
                right--;
            } else if (sum < M) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
