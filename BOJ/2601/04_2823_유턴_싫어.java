import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2823 유턴_싫어
 * 난이도: SILVER2
 * 유형: 그래프
 */
class Main_2823 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/04_2823_유턴_싫어.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int i = 0; i < R; ++i) {
            map[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (map[i][j] == '.') {
                    int cnt = 0;
                    // 상
                    if (i > 0 && map[i - 1][j] == '.') {
                        cnt++;
                    }
                    // 하
                    if (i < R - 1 && map[i + 1][j] == '.') {
                        cnt++;
                    }
                    // 좌
                    if (j > 0 && map[i][j - 1] == '.') {
                        cnt++;
                    }
                    // 우
                    if (j < C - 1 && map[i][j + 1] == '.') {
                        cnt++;
                    }
                    if (cnt <= 1) {
                        ans = 1;
                        break;
                    }
                }
            }
            if (ans == 1) {
                break;
            }
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
