import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 4143 Bridges_and_Tunnels
 * 난이도: GOLD3
 * 유형: 자료구조
 */
class Main_4143 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2603/15_4143_Bridges_and_Tunnels.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int idx = 0;
            int unionSize = 2 * n + 5;
            int[] union = new int[unionSize];
            for (int i = 0; i < unionSize; i++) {
                union[i] = -1;
            }
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a))
                    map.put(a, idx++);
                if (!map.containsKey(b))
                    map.put(b, idx++);
                sb.append(union(map.get(a), map.get(b), union)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int union(int a, int b, int[] union) {
        int rootA = find(a, union);
        int rootB = find(b, union);
        if (rootA == rootB)
            return -union[rootA];
        if (union[rootA] > union[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        union[rootA] += union[rootB];
        union[rootB] = rootA;
        return -union[rootA];
    }

    static int find(int a, int[] union) {
        if (union[a] < 0)
            return a;
        return union[a] = find(union[a], union);
    }
}
