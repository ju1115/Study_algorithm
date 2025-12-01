import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1167 트리의_지름
 * 난이도: GOLD2
 * 유형: 그래프
 */
class Main_1167 {
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

    static int dist;
    static ArrayList<Edge>[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/01_1167_트리의_지름.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            arr[now] = new ArrayList<>();
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1)
                    break;
                arr[now].add(new Edge(to, Integer.parseInt(st.nextToken())));
            }
        }
        int start = 1;
        int end = dfs(start);
        start = end;
        end = dfs(start);
        sb.append(dist);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int dfs(int s) {
        boolean[] visited = new boolean[N + 1];
        ArrayDeque<Edge> dq = new ArrayDeque<>();
        dq.add(new Edge(s, 0));
        visited[s] = true;
        int goal = 1;
        while (!dq.isEmpty()) {
            Edge now = dq.pollFirst();
            if (now.v > dist) {
                dist = now.v;
                goal = now.to;
            }
            for (Edge e : arr[now.to]) {
                int next = e.to;
                int v = e.v;
                if (visited[next])
                    continue;
                dq.addFirst(new Edge(next, now.v + v));
                visited[next] = true;
            }
        }
        return goal;
    }
}
