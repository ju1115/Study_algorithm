import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 20128 Parity_Constraint_Shortest_Path
 * 난이도: GOLD2
 * 유형: 그래프
 */
class Main_20128 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int to, v;

        Node(int to, int v) {
            this.to = to;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2602/17_20128_Parity_Constraint_Shortest_Path.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] arrayLists = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            arrayLists[i + 1] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arrayLists[a].add(new Node(b, v));
            arrayLists[b].add(new Node(a, v));
        }

        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
        dist[1][0] = 0;
        pq.add(new long[] { 1, 0, 0 });

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int currNode = (int) cur[0];
            long currDist = cur[1];
            int currParity = (int) cur[2];

            if (dist[currNode][currParity] < currDist)
                continue;

            for (Node next : arrayLists[currNode]) {
                long nextDist = currDist + next.v;
                int nextParity = (int) (nextDist % 2);

                if (dist[next.to][nextParity] > nextDist) {
                    dist[next.to][nextParity] = nextDist;
                    pq.add(new long[] { next.to, nextDist, nextParity });
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            long odd = dist[i][1] == Long.MAX_VALUE ? -1 : dist[i][1];
            long even = dist[i][0] == Long.MAX_VALUE ? -1 : dist[i][0];
            sb.append(odd).append(" ").append(even).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
