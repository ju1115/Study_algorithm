import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 15642 피보나치_수_7
 * 난이도: SILVER4
 * 유형: 수학
 */
class Main_15642 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/05_15642_피보나치_수_7.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        long mod = 1000000007L;
        long[] dp = new long[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        sb.append(dp[n]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
