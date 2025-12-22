import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2252 줄_세우기
 * 난이도: GOLD3
 * 유형: 위상정렬
 */
class Main_2252 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/22_2252_줄_세우기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] arr = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add(b);
            arr[b]++;
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                dq.add(i);
            }
        }
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            sb.append(cur).append(" ");
            for (int next : map.getOrDefault(cur, new ArrayList<>())) {
                arr[next]--;
                if (arr[next] == 0) {
                    dq.addFirst(next);
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
