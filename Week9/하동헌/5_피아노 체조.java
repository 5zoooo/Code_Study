import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] table;
    private static int[] cumSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        table = new int[N];
        cumSum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        table[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
            if (table[i] < table[i - 1]) {
                cumSum[i] = cumSum[i - 1] + 1;
            } else {
                cumSum[i] = cumSum[i - 1];
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(getMistake(x - 1, y - 1));
        }

        br.close();
    }

    private static int getMistake(int x, int y) {
        return cumSum[y] - cumSum[x];
    }
}
