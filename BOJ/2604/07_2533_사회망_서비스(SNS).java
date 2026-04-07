import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2533 사회망_서비스(SNS)
 * 난이도: GOLD3
 * 유형: 그래프
 */
class Main_2533 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2604/07_2533_사회망_서비스(SNS).txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][2];
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        ArrayList<Integer> order = new ArrayList<>();
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            int cur = order.get(i);
            int p = parent[cur];
            if (p == 0)
                continue;

            dp[p][0] += dp[cur][1];
            dp[p][1] += Math.min(dp[cur][0], dp[cur][1]);
        }
        sb.append(Math.min(dp[1][0], dp[1][1]));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(ArrayList<Integer>[] graph, int[][] dp) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (dp[next][0] == -1) {
                    dp[next][0] = dp[cur][1];
                    dp[next][1] = dp[cur][0] + 1;
                    q.addLast(next);
                } else {
                    dp[next][0] = Math.min(dp[next][0], dp[cur][1]);
                    dp[next][1] = Math.min(dp[next][1], dp[cur][0] + 1);
                }
            }
        }

    }
}
