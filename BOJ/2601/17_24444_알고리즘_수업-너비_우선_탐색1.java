import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 24444 알고리즘_수업-너비_우선_탐색1
 * 난이도: SILVER2
 * 유형: 그래프
 */
class Main_24444 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/17_24444_알고리즘_수업-너비_우선_탐색1.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(r);
        visited[r] = true;
        int[] ans = new int[n + 1];
        int cnt = 1;
        ans[r] = cnt;
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    dq.add(next);
                    visited[next] = true;
                    ans[next] = ++cnt;
                }
            }
        }
        for (int i = 1; i <= n; i++)
            sb.append(ans[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
