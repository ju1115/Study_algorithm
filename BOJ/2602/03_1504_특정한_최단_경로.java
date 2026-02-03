import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1504 특정한_최단_경로
 * 난이도: GOLD4
 * 유형: 그래프
 */
class Main_1504 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/03_1504_특정한_최단_경로.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long res1 = 0;
        res1 += dijkstra(1, v1, n, graph);
        res1 += dijkstra(v1, v2, n, graph);
        res1 += dijkstra(v2, n, n, graph);

        long res2 = 0;
        res2 += dijkstra(1, v2, n, graph);
        res2 += dijkstra(v2, v1, n, graph);
        res2 += dijkstra(v1, n, n, graph);

        long ans = Math.min(res1, res2);
        if (ans >= 200000000)
            sb.append(-1);
        else
            sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int dijkstra(int start, int end, int n, ArrayList<Node>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 200000000);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.weight > dist[curr.to])
                continue;

            for (Node next : graph[curr.to]) {
                if (dist[next.to] > dist[curr.to] + next.weight) {
                    dist[next.to] = dist[curr.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist[end];
    }

}
