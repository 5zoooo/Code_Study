import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int arr[];
    private static int nums[];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        br.close();
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        backtracking(0, 1);

    }

    public static void backtracking(int depth, int idx) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}