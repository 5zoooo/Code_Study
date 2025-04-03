import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> setN = new HashSet<>();
        for (int i = 0; i < N; i++) {
            setN.add(br.readLine());
        }

        HashSet<String> setRes = new HashSet<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (setN.contains(str)) {
                setRes.add(str);
            }
        }

        System.out.println(setRes.size());

        String[] arrAns= new String[setRes.size()];
        int idx = 0;
        for (String i: setRes) {
            arrAns[idx++] = i;
        }

        Arrays.sort(arrAns); // 사전 순으로 출력
        for (int i = 0; i < setRes.size(); i++) {
            System.out.println(arrAns[i]);
        }

        br.close();
    }
}
