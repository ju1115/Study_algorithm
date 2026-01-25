import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 12915 대회_개최
 * 난이도: GOLD5
 * 유형: 그리디
 */
class Main_12195 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/25_12915_대회_개최.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int em = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int mh = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int ans = 0;
        while (true) {
            boolean ec = false;
            boolean mc = false;
            boolean hc = false;
            if (e > 0) {
                ec = true;
                e--;
            }
            if (m > 0) {
                mc = true;
                m--;
            }
            if (h > 0) {
                hc = true;
                h--;
            }
            if (ec && mc && hc) {
                ans++;
                continue;
            }
            if (!ec) {
                if (em > 0) {
                    em--;
                    ec = true;
                } else {
                    break;
                }
            }
            if (!hc) {
                if (mh > 0) {
                    mh--;
                    hc = true;
                } else {
                    break;
                }
            }
            if (!mc) {
                if (em == 0 && mh == 0) {
                    break;
                }
                if (em > 0 && mh > 0) {
                    if (em + e > mh + h) {
                        em--;
                        mc = true;
                    } else {
                        mh--;
                        mc = true;
                    }
                } else {
                    if (em > 0) {
                        em--;
                        mc = true;
                    } else {
                        mh--;
                        mc = true;
                    }
                }
            }
            ans++;

        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
