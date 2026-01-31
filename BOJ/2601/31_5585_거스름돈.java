import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 5585 거스름돈
 * 난이도: BRONZE2
 * 유형: 그리디
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/31_5585_거스름돈.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[] coins = { 500, 100, 50, 10, 5, 1 };
        int num = 1000 - n;
        int ans = 0;
        for (int i = 0; i < coins.length; i++) {
            if (num >= coins[i]) {
                int count = num / coins[i];
                num %= coins[i];
                ans += count;
            }

        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
