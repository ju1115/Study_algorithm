import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2875 대회_or_인턴
 * 난이도: BRONZE3
 * 유형: 수학
 */
class Main_2875 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2511/25_2875_대회_or_인턴.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        while (k > 0) {
            if (n > m * 2) {
                n--;
                k--;
            } else {
                m--;
                k--;
            }
        }
        sb.append(Math.min(n / 2, m));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
