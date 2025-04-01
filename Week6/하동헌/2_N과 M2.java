import java.io.*;
import java.util.*;

// 방문을 확인하는 visit 배열이 없고, 대신 현재 위치를 확인하는 at 변수가 생겼다
// 즉, at 변수는 어디서부터 시작하는지를 의미하는 변수
public class Main {
    private static int N, M;
    private static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = new int[M];
        dfs(1, 0);

        br.close();
    }

    private static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
            res[depth] = i;
            dfs(i + 1, depth + 1); // 오름차순 유지
        }
    }
}
