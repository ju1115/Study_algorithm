import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 14469 소가_길을_건너간_이유_3
 * 난이도: SILVER3
 * 유형: 그리디
 */
class Main_14469 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Cow {
        int arrival;
        int time;

        Cow(int arrival, int time) {
            this.arrival = arrival;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/09_14469_소가_길을_건너간_이유_3.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(arrival, time);
        }
        Arrays.sort(cows, (a, b) -> {
            if (a.arrival == b.arrival)
                return a.time - b.time;
            return a.arrival - b.arrival;
        });
        PriorityQueue<Cow> pq = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });
        Cow firstCow = cows[0];
        int time = firstCow.arrival;
        pq.add(firstCow);
        int cowIdx = 1;
        while (!pq.isEmpty()) {
            Cow now = pq.poll();
            time += now.time;
            while (cowIdx < n && cows[cowIdx].arrival <= time) {
                pq.add(cows[cowIdx]);
                cowIdx++;
            }
            if (pq.isEmpty() && cowIdx < n) {
                time = cows[cowIdx].arrival;
                while (cowIdx < n && cows[cowIdx].arrival <= time) {
                    pq.add(cows[cowIdx]);
                    cowIdx++;
                }
            }
        }
        sb.append(time);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
