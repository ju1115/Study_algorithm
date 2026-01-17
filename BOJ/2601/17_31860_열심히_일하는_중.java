import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 31860 열심히_일하는_중
 * 난이도: SILVER2
 * 유형: 구현
 */
class Main_31860 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/17_31860_열심히_일하는_중.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int before = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur > k) {
                before = before / 2 + cur;
                ans.add(before);
                cur -= m;
                if (cur > k) {
                    pq.add(cur);
                }
            }
        }
        sb.append(ans.size()).append("\n");
        for (int num : ans) {
            sb.append(num).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
