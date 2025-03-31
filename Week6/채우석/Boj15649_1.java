package Week6.채우석;
import java.util.*;
// N과 M (1)
public class Boj15649_1 {
    static int n, m;
    static int[] result;
    static boolean[] visited;

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];
        visited = new boolean[n + 1];
        
        perm(0);
    }
    static void perm(int idx) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            result[idx] = i;
            visited[i] = true;
            perm(idx + 1);
            visited[i] = false;
        }
    }
}