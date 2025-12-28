import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2037 문자메시지
 * 난이도: BRONZE1
 * 유형: 구현
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/28_2037_문자메시지.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        char[] carr = input.toCharArray();
        int cur = -1;
        int ans = 0;
        for (char c : carr) {
            if (c == ' ') {
                ans += p;
                cur = -1;
                continue;
            }
            int now = c - 'A';
            int button;
            int cnt;
            if (now < 15) {
                button = now / 3;
                cnt = now % 3 + 1;

            } else if (now > 18 && now < 22) {
                button = 6;
                cnt = (now - 1) % 3 + 1;
            } else if (now > 14 && now <= 18) {
                button = 5;
                cnt = now % 5 + 1;
            } else {
                button = 7;
                cnt = now % 10 - 1;
            }
            if (cur == button) {
                ans += cnt * p;
                ans += w;
            } else {
                cur = button;
                ans += cnt * p;
            }

        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
