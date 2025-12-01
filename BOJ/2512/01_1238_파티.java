import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.io.*;

/**
 * 문제: BOJ 1238 파티
 * 난이도: GOLD3
 * 유형: 그래프
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int to;
        int v;

        Edge(int to, int v) {
            this.to = to;
            this.v = v;
        }
    }

    static ArrayList<Edge>[] edges;
    static int N, X;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/01_1238_파티.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int ans = 0;
        edges = new ArrayList[N + 1];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, dist));
        }
        for (int i = 1; i < N + 1; i++) {
            ans = Math.max(ans, dijk(i, X) + dijk(X, i));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int dijk(int from, int to) {
        int[] dist = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[from] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            return a.v - b.v;
        });
        for (Edge e : edges[from]) {
            dist[e.to] = e.v;
            pq.add(e);
        }
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            for (Edge e : edges[now.to]) {
                int nextDist = now.v + e.to;
                if (dist[e.to] > nextDist) {
                    dist[e.to] = nextDist;
                    pq.add(new Edge(e.to, nextDist));
                }
            }
        }
        return dist[to];
    }
}
