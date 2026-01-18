import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 33851 DAG_LCA
 * 난이도: GOLD4
 * 유형: 그래프
 */
class Main_33851 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class V {
        int node;
        int depth;

        V(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/18_33851_DAG_LCA.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], -1);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        for (int i = 1; i <= n; i++) {
            ArrayDeque<V> dq = new ArrayDeque<>();
            dq.add(new V(i, 0));

            boolean[] visited = new boolean[n + 1];
            visited[i] = true;

            while (!dq.isEmpty()) {
                V cur = dq.poll();

                dist[i][cur.node] = cur.depth;

                for (int next : graph[cur.node]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        dq.add(new V(next, cur.depth + 1));
                    }
                }
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int minMaxDist = Integer.MAX_VALUE;
            boolean found = false;

            for (int j = 1; j <= n; j++) {
                if (dist[j][u] != -1 && dist[j][v] != -1) {
                    int currentMax = Math.max(dist[j][u], dist[j][v]);

                    if (currentMax < minMaxDist) {
                        minMaxDist = currentMax;
                        found = true;
                    }
                }
            }

            if (found) {
                sb.append(minMaxDist).append("\n");
            } else {
                sb.append("-1\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
