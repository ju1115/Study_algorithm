import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25966 배찬우는_배열을_좋아해
 * 난이도: SILVER5
 * 유형: 구현
 */
class Main_25966 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/05_25966_배찬우는_배열을_좋아해.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[b][c] = d;
            } else {
                swap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void swap(int i, int j) {
        int[] temp = map[i];
        map[i] = map[j];
        map[j] = temp;
    }
}
