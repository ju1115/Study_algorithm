import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 9325 얼마
 * 난이도: BRONZE3
 * 유형: 수학
 */
class Main_9325 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/10_9325_얼마.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int price = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int ans = price;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int q = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                ans += q * p;
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
