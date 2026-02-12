import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 5549 행성_탐사
 * 난이도: GOLD5
 * 유형: 누적합
 */
class Main_5549 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][][] prefixSum;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/12_5549_행성_탐사.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        prefixSum = new int[n + 1][m + 1][3];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                char terrain = line.charAt(j - 1);

                int type = -1;
                if (terrain == 'J')
                    type = 0;
                else if (terrain == 'O')
                    type = 1;
                else if (terrain == 'I')
                    type = 2;

                for (int t = 0; t < 3; t++) {
                    int val = (type == t) ? 1 : 0;
                    prefixSum[i][j][t] = prefixSum[i - 1][j][t]
                            + prefixSum[i][j - 1][t]
                            - prefixSum[i - 1][j - 1][t]
                            + val;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int t = 0; t < 3; t++) {
                int count = prefixSum[x2][y2][t]
                        - prefixSum[x1 - 1][y2][t]
                        - prefixSum[x2][y1 - 1][t]
                        + prefixSum[x1 - 1][y1 - 1][t];

                sb.append(count).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
