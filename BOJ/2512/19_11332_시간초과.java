import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 11332 시간초과
 * 난이도: SILVER4
 * 유형: 구현
 */
class Main_11332 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String[] ans = { "May Pass.\n", "TLE!\n" };
    static int num = 100000000;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/19_11332_시간초과.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            long N = Integer.parseInt(st.nextToken());
            long T = Integer.parseInt(st.nextToken());
            long L = Integer.parseInt(st.nextToken());
            solve(s, N, T, L);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve(String s, long N, long T, long L) {
        long limit = L * num;
        long time = T;
        if (s.equals("O(N)")) {
            time *= N;
            if (limit < time) {
                sb.append(ans[1]);
            } else {
                sb.append(ans[0]);
            }
        } else if (s.equals("O(N^2)")) {
            time *= N * N;
            if (limit < time) {
                sb.append(ans[1]);
            } else {
                sb.append(ans[0]);
            }
        } else if (s.equals("O(N^3)")) {
            for (int i = 0; i < 3; i++) {
                time *= N;
                if (limit < time) {
                    sb.append(ans[1]);
                    return;
                }
            }
            sb.append(ans[0]);
        } else if (s.equals("O(2^N)")) {
            for (int i = 0; i < N; i++) {
                time *= 2;
                if (limit < time) {
                    sb.append(ans[1]);
                    return;
                }
            }
            sb.append(ans[0]);
        } else if (s.equals("O(N!)")) {
            for (int i = 1; i <= N; i++) {
                time *= i;
                if (limit < time) {
                    sb.append(ans[1]);
                    return;
                }
            }
            sb.append(ans[0]);
        }

    }
}
