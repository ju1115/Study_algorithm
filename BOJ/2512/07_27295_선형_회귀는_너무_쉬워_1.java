import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 27295 선형_회귀는_너무_쉬워_1
 * 난이도: SILVER5
 * 유형: 수학
 */
class Main_27295 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/07_27295_선형_회귀는_너무_쉬워_1.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken()) * n;
        long x = 0;
        long y = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x += Long.parseLong(st.nextToken());
            y += Long.parseLong(st.nextToken());
        }
        if (x == 0) {
            sb.append("EZPZ");
        } else if (y == b) {
            sb.append(0);
        } else {
            long p = y - b;
            long q = x;
            long gcdV = gcd(Math.abs(p), Math.abs(q));
            p = p / gcdV;
            q = q / gcdV;
            if (q < 0) {
                p = -p;
                q = -q;
            }
            if (q != 1) {
                sb.append(p + "/" + q);
            } else {
                sb.append(p);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static long gcd(long p, long q) {
        if (q == 0)
            return p;
        return gcd(q, p % q);

    }
}
