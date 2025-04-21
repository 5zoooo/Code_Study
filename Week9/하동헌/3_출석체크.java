import java.io.*;
import java.util.*;

// 누적 합 사용 X
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> sleepingStudents = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sleepingStudents.add(Integer.parseInt(st.nextToken()));
        }

        int[] targetStudents = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            targetStudents[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N + 3];
        Arrays.fill(visited, false);

        // 조는 학생을 고려한 출석 코드 전파
        for (int i = 0; i < targetStudents.length; i++) {
            int cur = targetStudents[i];
            if (sleepingStudents.contains(cur)) {
                continue;
            }

            for (int multiple = 1; cur * multiple <= N + 2; multiple++) {
                if (!sleepingStudents.contains(cur * multiple)) {
                    visited[cur * multiple] = true;
                }
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = S; i <= E; i++) {
                if (!visited[i]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

        br.close();
    }
}
