import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 1005 ACM_Craft
 * 난이도: GOLD3
 * 유형: 위상정렬
 */
class Main_1005 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Build {
        ArrayList<Integer> next;
        int time;
        int num;
        int rank;
        int startTime;

        Build(int time, int num) {
            this.time = time;
            this.num = num;
            next = new ArrayList<>();
            rank = 0;
            startTime = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2604/06_1005_ACM_Craft.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Code here
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Build[] build = new Build[n + 1];
            for (int i = 1; i <= n; i++) {
                build[i] = new Build(Integer.parseInt(st.nextToken()), i);
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                build[a].next.add(b);
                build[b].rank++;
            }
            int w = Integer.parseInt(br.readLine());
            PriorityQueue<Build> pq = new PriorityQueue<>((a, b) -> a.startTime - b.startTime);
            for (int i = 1; i <= n; i++) {
                if (build[i].rank == 0) {
                    pq.add(build[i]);
                }
            }
            while (!pq.isEmpty()) {
                Build cur = pq.poll();
                if (cur.num == w) {
                    sb.append(cur.startTime + cur.time).append("\n");
                    break;
                }
                for (int i = 0; i < cur.next.size(); i++) {
                    Build next = build[cur.next.get(i)];
                    next.rank--;
                    next.startTime = Math.max(next.startTime, cur.startTime + cur.time);
                    if (next.rank == 0) {
                        pq.add(next);
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
