import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1890 점프
 * 난이도: SILVER1
 * 유형: DP
 */
class _1890 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/15_1890_점프.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0 || (i == n - 1 && j == n - 1))
                    continue;
                int jump = arr[i][j];
                if (i + jump < n) {
                    dp[i + jump][j] += dp[i][j];
                }
                if (j + jump < n) {
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        sb.append(dp[n - 1][n - 1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
