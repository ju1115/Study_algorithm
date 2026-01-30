import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 33993 지정좌석제
 * 난이도: GOLD5
 * 유형: 구현
 */
class Main_33993 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/29_33993_지정좌석제.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int ans = 0;
        int ansx = 0;
        int ansy = 0;
        int[][] map = new int[R][C];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = -1;
            for (int j = -(W / 2); j <= W / 2; j++) {
                for (int k = -(W / 2); k <= W / 2; k++) {
                    int nx = x + j;
                    int ny = y + k;
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (map[nx][ny] != -1) {
                            map[nx][ny]++;
                        }
                    }
                }

            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > ans) {
                    ans = map[i][j];
                    ansx = i;
                    ansy = j;
                }
            }
        }
        sb.append(ans).append("\n").append(ansx + 1).append(" ").append(ansy + 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
