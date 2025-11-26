import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1967 트리의_지름
 * 난이도: GOLD4
 * 유형: 그래프,트리
 */
class Main_1967 {
    static class Node {
        int to;
        int v;

        Node(int to, int v) {
            this.to = to;
            this.v = v;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static int maxV;
    static int endP;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2511/25_1967_트리의_지름.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];

        if (N == 1) {
            sb.append(0);
            bw.write(sb.toString());
            bw.close();
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[parent].add(new Node(child, v));
            adj[child].add(new Node(parent, v));
        }
        maxV = 0;
        endP = 0;
        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(endP, 0);

        sb.append(maxV);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int now, int curV) {
        visited[now] = true;

        if (maxV < curV) {
            maxV = curV;
            endP = now;
        }

        for (int i = 0; i < adj[now].size(); i++) {
            Node next = adj[now].get(i);
            if (visited[next.to])
                continue;
            dfs(next.to, curV + next.v);
        }
    }
}
