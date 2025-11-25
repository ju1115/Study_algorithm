import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1967 트리의_지름
 * 난이도: GOLD4
 * 유형: 그래프,트리
 */
class Main {
    static class Node {
        Node parent;
        int v;
        int id;

        Node(Node parent, int v, int id) {
            this.parent = parent;
            this.v = v;
            this.id = id;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static HashSet<Integer> isLeaf = new HashSet<>(10000);

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2511/25_1967_트리의_지름.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        HashMap<Integer, Node> nodes = new HashMap<>();

        nodes.put(1, new Node(null, 0, 1));
        isLeaf.add(1);
        int N = Integer.parseInt(br.readLine());
        // N-1 개 raw
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Node parentNode = nodes.get(parent);
            nodes.put(child, new Node(parentNode, parentNode.v + v, child));
            isLeaf.remove(parent);
            isLeaf.add(child);
        }
        List<Integer> leafList = new ArrayList<>(isLeaf);
        isLeaf.add(1);
        isLeaf.clear();
        Node first = nodes.get(leafList.get(0));
        int ans = 0;
        int ansi = 0;
        for (int i = 1; i < leafList.size(); i++) {
            int between = calculate(first, nodes.get(leafList.get(i)));
            if (ans < between) {
                ans = between;
                ansi = i;
            }
        }
        ans = 0;
        first = nodes.get(leafList.get(ansi));
        for (int i = 0; i < leafList.size(); i++) {
            if (i == ansi)
                continue;
            int between = calculate(first, nodes.get(leafList.get(i)));
            if (ans < between) {
                ans = between;
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int calculate(Node i, Node j) {
        int originalIv = i.v;
        int originalJv = j.v;

        Node tempI = i;
        while (tempI != null) {
            isLeaf.add(tempI.id);
            tempI = tempI.parent;
        }

        Node lca = j;
        while (lca != null) {
            if (isLeaf.contains(lca.id)) {
                break;
            }
            lca = lca.parent;
        }

        isLeaf.clear();

        return originalIv + originalJv - 2 * lca.v;
    }
}
