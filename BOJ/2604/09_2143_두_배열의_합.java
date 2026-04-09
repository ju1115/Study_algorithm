import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2143 두_배열의_합
 * 난이도: GOLD3
 * 유형: 이분탐색
 */
class Main_2143 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2604/09_2143_두_배열의_합.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        long t = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        a[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + Long.parseLong(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] b = new long[m];
        b[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < m; i++) {
            b[i] = b[i - 1] + Long.parseLong(st.nextToken());
        }
        HashMap<Long, Integer> sumA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum = (a[j] - (i == 0 ? 0 : a[i - 1]));
                sumA.put(sum, sumA.getOrDefault(sum, 0) + 1);
            }
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                long sum = (b[j] - (i == 0 ? 0 : b[i - 1]));
                ans += sumA.getOrDefault(t - sum, 0);
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
