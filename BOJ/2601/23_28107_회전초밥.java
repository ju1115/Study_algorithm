import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 28107 회전초밥
 * 난이도: SILVER1
 * 유형: 자료구조
 */
class Main_28107 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/23_28107_회전초밥.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer>[] dqs = new ArrayDeque[200001];
        int[] ans = new int[n + 1];
        for (int i = 1; i < 200001; i++) {
            dqs[i] = new ArrayDeque<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int order = Integer.parseInt(st.nextToken());
                dqs[order].add(i);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int order = Integer.parseInt(st.nextToken());
            if (dqs[order].isEmpty()) {
                continue;
            } else {
                int eater = dqs[order].pollFirst();
                ans[eater]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
