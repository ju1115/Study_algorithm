import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 15006 Detour
 * 난이도: GOLD2
 * 유형: 그래프
 */
class Main_15006 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/03_15006_Detour.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
            adj[b].add(new Edge(a, c));
        }
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (dist[cur.to] < cur.weight) {
                continue;
            }
            for (Edge next : adj[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.weight) {
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }

        boolean[] visited = new boolean[n];
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(0);
        visited[0] = true;
        int head = 0;
        boolean found = false;

        while (head < queue.size()) {
            int cur = queue.get(head++);
            if (cur == 1) {
                found = true;
                break;
            }

            for (Edge next : adj[cur]) {
                if (!visited[next.to] && dist[cur] != dist[next.to] + next.weight) {
                    visited[next.to] = true;
                    parent[next.to] = cur;
                    queue.add(next.to);
                }
            }
        }

        if (found) {
            ArrayList<Integer> path = new ArrayList<>();
            int curr = 1;
            while (curr != -1) {
                path.add(curr);
                curr = parent[curr];
            }
            sb.append(path.size());
            for (int i = path.size() - 1; i >= 0; i--) {
                sb.append(" ").append(path.get(i));
            }
        } else {
            sb.append("impossible");
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
