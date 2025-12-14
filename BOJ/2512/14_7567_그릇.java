import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 7567 그릇
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_7567 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/14_7567_그릇.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String s = br.readLine();
        char[] arr = s.toCharArray();
        char now = 'a';
        int ans = 0;
        for (char c : arr) {
            if (c != now) {
                ans += 10;
                now = c;
            } else {
                ans += 5;
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
