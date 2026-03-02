import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 9010 Möbius_Strip
 * 난이도: GOLD3
 * 유형: 수학
 */
class Main_9010 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/02_9010_Möbius_Strip.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            double m = Double.parseDouble(st.nextToken());
            double n = Double.parseDouble(st.nextToken());
            double result = (3.0 * m * n + 2.0 * (m - 1) * (m + 1)) / (6.0 * m);
            sb.append(String.format("%.1f", result)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
