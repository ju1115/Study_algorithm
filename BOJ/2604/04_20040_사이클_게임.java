import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 20040 사이클_게임
 * 난이도: gold4
 * 유형: UnionFind
 */
class Main_20040 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2604/04_20040_사이클_게임.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] union = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a = find(union, a);
            b = find(union, b);
            if (a == b) {
                sb.append(i + 1).append("\n");
                break;
            }
            union(union, a, b);
        }
        if (sb.length() == 0) {
            sb.append(0).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void union(int[] union, int a, int b) {
        a = find(union, a);
        b = find(union, b);
        if (a == b) {
            return;
        }
        if (union[a] < union[b]) {
            union[a] += union[b];
            union[b] = a;
        } else {
            union[b] += union[a];
            union[a] = b;
        }
        return;
    }

    static int find(int[] union, int a) {
        if (union[a] < 0) {
            return a;
        }
        return union[a] = find(union, union[a]);
    }
}
