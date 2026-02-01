import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 18234 당근_훔쳐_먹기
 * 난이도: GOLD3
 * 유형: 그리디
 */
class Main_18234 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Seed {
        long w;
        long p;

        public Seed(long w, long p) {
            this.w = w;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/01_18234_당근_훔쳐_먹기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        ArrayList<Seed> seeds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            seeds.add(new Seed(a, b));
        }
        Collections.sort(seeds, (o1, o2) -> {
            if (o1.p == o2.p) {
                return Long.compare(o2.w, o1.w);
            }
            return Long.compare(o2.p, o1.p);
        });
        int idx = 0;
        long ans = 0;
        for (int time = 1; time <= n; time++) {
            Seed seed = seeds.get(idx++);
            ans += seed.w + seed.p * (t - time);
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
