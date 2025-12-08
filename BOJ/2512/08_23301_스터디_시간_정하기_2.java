import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

/**
 * 문제: BOJ 23301 스터디_시간_정하기_2
 * 난이도: SILVER4
 * 유형: 브루트포스
 */
class Main_23301 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Time {
        int s;
        int e;

        Time(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/08_23301_스터디_시간_정하기_2.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        ArrayList<Time>[] times = new ArrayList[n];
        int maxe = 0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            times[i] = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                times[i].add(new Time(s, e));
                maxe = Math.max(maxe, e);
            }
        }
        int ans = 0;
        int sans = 0;
        for (int i = 0; i + t <= maxe; i++) {
            int ie = i + t;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                for (Time time : times[j]) {
                    if (time.s > ie || time.e < i)
                        continue;
                    sum += Math.min(time.e, ie) - Math.max(time.s, i);
                }
            }
            if (sum > ans) {
                ans = sum;
                sans = i;
            }
        }
        sb.append(sans + " " + (sans + t));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
