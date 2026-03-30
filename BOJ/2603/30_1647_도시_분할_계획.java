import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1647 도시_분할_계획
 * 난이도: GOLD4
 * 유형: 그래프
 */
class Main_1647 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int from, to, edge;

        Edge(int from, int to, int edge) {
            this.from = from;
            this.to = to;
            this.edge = edge;
        }
    }

    static int[] union;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/30_1647_도시_분할_계획.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        union = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            union[i] = -1;
        }
        pq = new PriorityQueue<>((a, b) -> a.edge - b.edge);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, c));
        }
        int ans = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (find(cur.from) == find(cur.to))
                continue;
            union(cur.from, cur.to);
            ans += cur.edge;
            max = Math.max(max, cur.edge);
        }
        sb.append(ans - max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int find(int x) {
        if (union[x] < 0) {
            return x;
        }
        return union[x] = find(union[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
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
