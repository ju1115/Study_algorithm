import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 26595 전투의_신
 * 난이도: SILVER5
 * 유형: 브루트포스
 */
class Main_26595 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/06_26595_전투의_신.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int pa = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int pb = Integer.parseInt(st.nextToken());
        long ans = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i <= n / pa; i++) {
            int j = (n - pa * i) / pb;
            long v = (long) a * i + (long) b * j;
            if (ans < v) {
                ans = v;
                x = i;
                y = j;
            }
        }
        sb.append(x + " " + y);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
