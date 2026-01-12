import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2705 팰린드롬_파티션
 * 난이도: SILVER1
 * 유형: DP
 */
class Main_2705 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/12_2705_팰린드롬_파티션.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int[] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 1000; i++) {
            dp[i] = dp[i - 2] + dp[i / 2];
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
