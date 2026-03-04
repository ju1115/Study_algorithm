import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 28986 Погружение_в_Анимус
 * 난이도: BRONZE2
 * 유형: 수학
 */
class Main_28986 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2603/04_28986_Погружение_в_Анимус.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long min = Math.max(1, k - n);
        long max = (k - 1) / 2;
        long answer = Math.max(0L, max - min + 1L);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
