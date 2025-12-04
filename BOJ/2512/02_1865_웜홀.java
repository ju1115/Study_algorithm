import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1865 웜홀
 * 난이도: GOLD3
 * 유형: 그래프
 */
class Main_1865 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // static class Edge {
    // int to;
    // int v;

    // Edge(int to, int v) {
    // this.to = to;
    // this.v = v;
    // }
    // }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/02_1865_웜홀.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[][] dist = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j)
                        continue;
                    dist[i][j] = Integer.MAX_VALUE / 2;
                }
            }
            // ArrayList<Edge>[] edges = new ArrayList[N + 1];
            // for (int i = 1; i <= N; i++) {
            // edges[i] = new ArrayList<>();
            // }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                dist[s][e] = Math.min(dist[s][e], t);
                dist[e][s] = Math.min(dist[e][s], t);
                // edges[s].add(new Edge(e, t));
                // edges[e].add(new Edge(s, t));
            }
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                dist[s][e] = -t;
                // edges[s].add(new Edge(e, -t));
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            // for (int i = 1; i <= N; i++) {
            // for (int j = 1; j <= N; j++) {
            // sb.append(dist[i][j]).append(" ");
            // }
            // sb.append("\n");
            // }
            boolean loop = false;
            for (int i = 1; i <= N; i++) {
                if (dist[i][i] < 0) {
                    loop = true;
                }
            }
            if (loop)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
