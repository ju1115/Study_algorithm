import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2520 팬케이크_사랑
 * 난이도: BRONZE2
 * 유형: 수학
 */
class Main_2520 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2511/25_2520_팬케이크_사랑.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int batter = (int) (Integer.parseInt(st.nextToken()) / 0.5);
            batter = Math.min((int) (Integer.parseInt(st.nextToken()) / 0.5), batter);
            batter = Math.min((int) (Integer.parseInt(st.nextToken()) / 0.25), batter);
            batter = Math.min((int) (Integer.parseInt(st.nextToken()) / (1.0 / 16)), batter);
            batter = Math.min((int) (Integer.parseInt(st.nextToken()) / (9.0 / 16)), batter);
            st = new StringTokenizer(br.readLine());
            int toping = Integer.parseInt(st.nextToken()) / 1;
            toping += Integer.parseInt(st.nextToken()) / 30;
            toping += Integer.parseInt(st.nextToken()) / 25;
            toping += Integer.parseInt(st.nextToken()) / 10;
            sb.append(Math.min(batter, toping)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
