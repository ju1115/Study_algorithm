import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 9252 LCS_2
 * 난이도: GOLD3
 * 유형: 문자열
 */
class Main_9252 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2604/12_9252_LCS_2.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        sb.append(dp[a.length][b.length]).append("\n");
        int i = a.length;
        int j = b.length;
        char[] ans = new char[dp[a.length][b.length]];
        int idx = 0;
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                ans[idx++] = a[i - 1];
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        for (int k = idx - 1; k >= 0; k--) {
            sb.append(ans[k]);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
