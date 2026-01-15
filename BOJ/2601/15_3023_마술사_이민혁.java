import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 3023 마술사_이민혁
 * 난이도: BRONZE1
 * 유형: 구현
 */
class Main_3023 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/15_3023_마술사_이민혁.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        // '.' 이 true
        boolean[][] map = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String str = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = str.charAt(j) == '.';
            }
        }
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        boolean[][] newMap = new boolean[h * 2][w * 2];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                newMap[i][j] = map[i][j];
                newMap[i][w * 2 - 1 - j] = map[i][j];
                newMap[h * 2 - 1 - i][j] = map[i][j];
                newMap[h * 2 - 1 - i][w * 2 - 1 - j] = map[i][j];
            }
        }
        newMap[r][c] = !newMap[r][c];

        for (int i = 0; i < h * 2; i++) {
            for (int j = 0; j < w * 2; j++) {
                sb.append(newMap[i][j] ? '.' : '#');
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
