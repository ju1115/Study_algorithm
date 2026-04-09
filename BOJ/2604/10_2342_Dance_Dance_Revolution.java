import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 2342 Dance_Dance_Revolution
 * 난이도: GOLD3
 * 유형: DP
 */
class Main_2342 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2604/10_2342_Dance_Dance_Revolution.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int[][][] dp = new int[5][5][100005];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100005; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][0][0] = 0;
        int input;
        int cnt = 0;
        while ((input = Integer.parseInt(st.nextToken())) != 0) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (dp[i][j][cnt] == Integer.MAX_VALUE)
                        continue;
                    if (input != j)
                        dp[input][j][cnt + 1] = Math.min(dp[input][j][cnt + 1], dp[i][j][cnt] + cost(i, input));
                    if (input != i)
                        dp[i][input][cnt + 1] = Math.min(dp[i][input][cnt + 1], dp[i][j][cnt] + cost(j, input));
                }
            }
            cnt++;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ans = Math.min(ans, dp[i][j][cnt]);
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int cost(int a, int b) {
        if (a == b)
            return 1;
        if (a == 0)
            return 2;
        if (Math.abs(a - b) == 2)
            return 4;
        return 3;
    }
}
