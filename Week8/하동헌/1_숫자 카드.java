import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] table = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table);

        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());

            if (Arrays.binarySearch(table, key) >= 0) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }

        br.close();
    }
}
