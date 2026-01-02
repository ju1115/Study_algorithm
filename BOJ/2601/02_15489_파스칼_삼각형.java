import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 15489 파스칼_삼각형
 * 난이도: SILVER4
 * 유형: DP
 */
class Main_15489 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/02_15489_파스칼_삼각형.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[31][31];
        dp[1][1] = 1;

        for (int i = 2; i <= 30; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int sum = 0;
        for (int i = 0; i < W; ++i) {
            for (int j = 0; j <= i; ++j) {
                sum += dp[R + i][C + j];
            }
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
