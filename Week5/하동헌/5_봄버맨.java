import java.io.*;
import java.util.*;

public class Main {
    private static int R, C;
    private static char[][] inputMap;
    private static int[] di = {-1, 1, 0, 0}; // 상, 하
    private static int[] dj = {0, 0, -1, 1}; // 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        inputMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                inputMap[i][j] = str.charAt(j);
            }
        }

        char[][] ans = getAnsMap(N);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }

        br.close();
    }

    private static char[][] getAnsMap(int N) {
        if (N == 1) { // 그냥 초기 맵 그대로 반환
            return inputMap;
        }
        if (N % 2 == 0) { // 폭탄이 가득한 맵을 반환
            return getAllBombMap();
        }

        char[][] firstBlastMap = getBlastMap(inputMap);
        if (N % 4 == 3) { // 폭탄이 첫 번째 터진 맵을 반환
            return firstBlastMap;
        } else { // 폭탄이 두 번째 터진 맵을 반환
            return getBlastMap(firstBlastMap);
        }
    }

    private static char[][] getAllBombMap() {
        char[][] res = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i][j] = 'O';
            }
        }
        return res;
    }

    private static char[][] getBlastMap(char[][] map) {
        // 전부 폭탄으로 채우고 상하좌우로 '.'만 찾는다는 마인드
        char[][] res = getAllBombMap();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    res[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int nextI = i + di[k];
                        int nextJ = j + dj[k];
                        if (nextI >= 0 && nextI < R && nextJ >= 0 && nextJ < C) {
                            res[nextI][nextJ] = '.';
                        }
                    }
                }
            }
        }
        return res;
    }
}
