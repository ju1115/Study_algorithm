import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 12996 Acka
 * 난이도: GOLD3
 * 유형: DP
 */
class Main_12996 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/09_12996_Acka.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());

        int[][][][] dp = new int[s + 1][targetA + 1][targetB + 1][targetC + 1];

        dp[0][0][0][0] = 1;
        long MOD = 1000000007;
        for (int i = 0; i < s; i++) {
            for (int a = 0; a <= targetA; a++) {
                for (int b = 0; b <= targetB; b++) {
                    for (int c = 0; c <= targetC; c++) {

                        if (dp[i][a][b][c] == 0)
                            continue;

                        long currentVal = dp[i][a][b][c];

                        if (a + 1 <= targetA)
                            dp[i + 1][a + 1][b][c] = (int) ((dp[i + 1][a + 1][b][c] + currentVal) % MOD);
                        if (b + 1 <= targetB)
                            dp[i + 1][a][b + 1][c] = (int) ((dp[i + 1][a][b + 1][c] + currentVal) % MOD);
                        if (c + 1 <= targetC)
                            dp[i + 1][a][b][c + 1] = (int) ((dp[i + 1][a][b][c + 1] + currentVal) % MOD);
                        if (a + 1 <= targetA && b + 1 <= targetB)
                            dp[i + 1][a + 1][b + 1][c] = (int) ((dp[i + 1][a + 1][b + 1][c] + currentVal) % MOD);
                        if (a + 1 <= targetA && c + 1 <= targetC)
                            dp[i + 1][a + 1][b][c + 1] = (int) ((dp[i + 1][a + 1][b][c + 1] + currentVal) % MOD);
                        if (b + 1 <= targetB && c + 1 <= targetC)
                            dp[i + 1][a][b + 1][c + 1] = (int) ((dp[i + 1][a][b + 1][c + 1] + currentVal) % MOD);
                        if (a + 1 <= targetA && b + 1 <= targetB && c + 1 <= targetC)
                            dp[i + 1][a + 1][b + 1][c
                                    + 1] = (int) ((dp[i + 1][a + 1][b + 1][c + 1] + currentVal) % MOD);
                    }
                }
            }
        }
        sb.append(dp[s][targetA][targetB][targetC]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
