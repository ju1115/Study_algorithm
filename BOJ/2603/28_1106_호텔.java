import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1106 호텔
 * 난이도: GOLD4
 * 유형: DP
 */
class Main_1106 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/28_1106_호텔.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[c + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int j = customer; j < c + customer; j++) {
                if (dp[j - customer] == Integer.MAX_VALUE)
                    continue;
                if (j <= c) {
                    dp[j] = Math.min(dp[j], dp[j - customer] + cost);
                } else {
                    dp[c] = Math.min(dp[c], dp[j - customer] + cost);
                }
            }
        }
        sb.append(dp[c]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
