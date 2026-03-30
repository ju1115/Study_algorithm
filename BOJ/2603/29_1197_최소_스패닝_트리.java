import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1197 최소_스패닝_트리
 * 난이도: GOLD4
 * 유형: 그래프
 */
class Main_1197 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int from, to;
        long weight;

        Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/29_1197_최소_스패닝_트리.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] union = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            union[i] = -1;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            pq.add(new Edge(a, b, c));
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (find(cur.from, union) == find(cur.to, union))
                continue;
            union(cur.from, cur.to, union);
            ans += cur.weight;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int find(int x, int[] union) {
        if (union[x] < 0) {
            return x;
        }
        return union[x] = find(union[x], union);
    }

    static void union(int x, int y, int[] union) {
        x = find(x, union);
        y = find(y, union);
        if (x == y)
            return;
        if (union[x] < union[y]) {
            union[x] += union[y];
            union[y] = x;
        } else {
            union[y] += union[x];
            union[x] = y;
        }
    }
}
