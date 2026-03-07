import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 16150 Gun_Control
 * 난이도: GOLD3
 * 유형: dp
 */
class Main_16150 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/07_16150_Gun_Control.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int k = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= k; tc++) {
            sb.append("Data Set ").append(tc).append(":\n");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] dp = new int[b + 2];
            for (int i = 1; i <= b + 1; i++) {
                dp[i] = Integer.MAX_VALUE;
            }

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                for (int currentCost = b + 1; currentCost >= 0; currentCost--) {
                    if (dp[currentCost] != Integer.MAX_VALUE) {
                        int nextCost = Math.min(b + 1, currentCost + a);
                        dp[nextCost] = Math.min(dp[nextCost], dp[currentCost] + c);
                    }
                }
            }

            sb.append(dp[b + 1]).append("\n\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
