import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 31477 양갈래 구하기
 * 난이도: GOLD3
 * 유형: 그래프
 */
class Main_31477 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        ArrayList<Node> childrenNodes;
        int value;

        Node(int value) {
            this.value = value;
            childrenNodes = new ArrayList<>();
        }

        int getValue() {
            if (childrenNodes.size() == 0) {
                return value;
            } else {
                int sum = 0;
                for (Node node : childrenNodes) {
                    sum += node.getValue();
                }
                return Math.min(sum, value);
            }
        }
    }

    static class Vol {
        int to;
        int v;

        Vol(int to, int v) {
            this.to = to;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/16_31477_양갈래 구하기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        ArrayList<Vol>[] arrayLists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arrayLists[a].add(new Vol(b, v));
            arrayLists[b].add(new Vol(a, v));
        }
        Node[] nodes = new Node[n + 1];
        nodes[1] = new Node(Integer.MAX_VALUE);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        dq.add(1);
        visited[1] = true;
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            for (Vol next : arrayLists[cur]) {
                int to = next.to;
                int v = next.v;
                if (!visited[to]) {
                    visited[to] = true;
                    Node nextNode = new Node(v);
                    nodes[to] = nextNode;
                    dq.add(to);
                    nodes[cur].childrenNodes.add(nextNode);
                }
            }
        }
        sb.append(nodes[1].getValue());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
