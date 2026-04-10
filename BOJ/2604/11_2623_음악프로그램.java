import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2623 음악프로그램
 * 난이도: GOLD3
 * 유형: 그래프
 */
class Main_2623 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2604/11_2623_음악프로그램.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            for (int j = 0; j < k; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < k - 1; j++) {
                graph[arr[j]].add(arr[j + 1]);
                d[arr[j + 1]]++;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append("\n");
            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                d[next]--;
                if (d[next] == 0) {
                    pq.add(next);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (d[i] != 0) {
                sb = new StringBuilder();
                sb.append(0).append("\n");
                break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
