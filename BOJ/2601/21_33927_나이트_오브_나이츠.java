import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 33927 나이트_오브_나이츠
 * 난이도: SILVER2
 * 유형: 백트래킹
 */
class Main_33927 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static boolean[][] chess;
    static int n, ans, max, cnt = 0;
    static int[] dr = { -2, -2, -1, -1 }, dc = { -1, 1, -2, 2 };

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/21_33927_나이트_오브_나이츠.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        chess = new boolean[n][n];
        max = (int) Math.pow(n, 2);
        backtracking(0, 0);
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void backtracking(int depth, int cnt) {

        if (depth == max) {
            ans = Math.max(ans, cnt);
            return;
        }
        int r = depth / n;
        int c = depth % n;
        if (check(r, c)) {
            chess[r][c] = true;
            backtracking(depth + 1, cnt + map[r][c]);
            chess[r][c] = false;
        }
        backtracking(depth + 1, cnt);
    };

    static boolean check(int r, int c) {

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (chess[nr][nc])
                    return false;
            }
        }
        return true;
    }
}
