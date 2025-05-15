import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int absMin = 2147483647;
        int l = 0;
        int r = arr.length - 1;
        int ansIdx1 = 0, ansIdx2 = 0;
        while (l < r) {
            int res = arr[l] + arr[r];
            int absRes = Math.abs(arr[l] + arr[r]);
            if (absRes < absMin) {
                absMin = absRes;
                ansIdx1 = l;
                ansIdx2 = r;
            }

            if (res < 0) { // 합이 음수면 더 큰 수가 필요
                l++;
            } else { // 합이 양수면 더 작은 수가 필요
                r--;
            }
        }

        System.out.println(arr[ansIdx1] + " " + arr[ansIdx2]);

        br.close();
    }
}

/*
-99 -2 -1 4 98: -99 98
-50 -10 0 5 120: -10 5 or 0 5
*/
