import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 5557 1학년
 * 난이도: GOLD5
 * 유형: DP
 */
class Main_5557 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/18_5557_1학년.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n - 1][21]; // dp[i][j] = i번째 숫자까지 계산했을 때 j가 되는 경우의 수
        dp[0][arr[0]] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) { // 이전 단계에서 j 값을 만들 수 있었다면
                    // 덧셈
                    if (j + arr[i] <= 20) {
                        dp[i][j + arr[i]] += dp[i - 1][j];
                    }
                    // 뺄셈
                    if (j - arr[i] >= 0) {
                        dp[i][j - arr[i]] += dp[i - 1][j];
                    }
                }
            }
        }
        sb.append(dp[n - 2][arr[n - 1]]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
