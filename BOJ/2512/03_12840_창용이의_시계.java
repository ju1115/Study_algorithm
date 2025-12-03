import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 12840 창용이의_시계
 * 난이도: BRONZE3
 * 유형: 구현
 */
class Main_12840 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int h, m, s;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/03_12840_창용이의_시계.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(br.readLine());
        for (int t = 0; t < q; t++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            if (T == 3) {
                sb.append(h).append(" ").append(m).append(" ").append(s).append("\n");
            } else if (T == 1) {
                int sec = Integer.parseInt(st.nextToken());
                int hp = sec / 3600;
                int mp = sec / 60 % 60;
                int sp = sec % 60;
                s += sp;
                m += s / 60;
                s %= 60;
                m += mp;
                h += m / 60;
                m %= 60;
                h += hp;
                h %= 24;
            } else {
                int sec = Integer.parseInt(st.nextToken());
                int hp = sec / 3600;
                int mp = sec / 60 % 60;
                int sp = sec % 60;
                h += 240000 - hp - 1;
                m -= mp - 59;
                s -= sp - 60;
                m += s / 60;
                s %= 60;
                h += m / 60;
                m %= 60;
                h %= 24;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
