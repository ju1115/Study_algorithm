import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 15681 트리와_쿼리
 * 난이도: GOLD5
 * 유형: 그래프
 */
class Main_15681 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] dp;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/27_15681_트리와_쿼리.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        dp = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dp(r, 0);
        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(dp[query]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int dp(int n, int parent) {
        dp[n] = 1;
        for (int i : tree[n]) {
            if (i == parent)
                continue;
            dp[n] += dp(i, n);
        }
        return dp[n];
    }
}
