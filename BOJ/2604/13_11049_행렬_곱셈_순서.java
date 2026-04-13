import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 11049 행렬_곱셈_순서
 * 난이도: GOLD3
 * 유형: DP
 */
class Main_11049 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2604/13_11049_행렬_곱셈_순서.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        for (int len = 1; len < n; len++) {
            for (int i = 1; i + len <= n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + (arr[i][0] * arr[k][1] * arr[j][1]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        sb.append(dp[1][n]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
