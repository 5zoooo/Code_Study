import java.io.*;
import java.util.*;

// 투 포인터(슬라이딩 윈도우)
// 오른쪽 포인터는 계속 확장하고, 왼쪽 포인터는 조건을 회복하는 구조
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] visited = new int[100001];
        int maxLen = 0;
        int l = 0;
        for (int r = 0; r < arr.length; r++) {
            visited[arr[r]]++;
            while (visited[arr[r]] > K) {
                visited[arr[l]]--;
                l++;
            }

            maxLen = Math.max(r - l + 1, maxLen);
        }

        System.out.println(maxLen);

        br.close();
    }
}
// 만약 K번을 초과하면 l을 오른쪽으로 이동시켜서 해결
// 이 과정을 통해 윈도우 안에는 항상 K번 이하로만 등장
