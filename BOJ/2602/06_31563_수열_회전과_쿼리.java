import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 31563 수열_회전과_쿼리
 * 난이도: SILVER2
 * 유형: 수학
 */
class Main_31563 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/06_31563_수열_회전과_쿼리.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        long[] map = new long[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            map[i] = sum;
        }

        int startIdx = 0;

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if (k == 1) {
                int v = Integer.parseInt(st.nextToken());
                startIdx = (startIdx - v + n) % n;
            } else if (k == 2) {
                int v = Integer.parseInt(st.nextToken());
                startIdx = (startIdx + v) % n;
            } else if (k == 3) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int s = (startIdx + a - 2 + n) % n;
                int e = (startIdx + b - 1) % n;

                if (e > s) {
                    sb.append(map[e] - map[s]).append("\n");
                } else {
                    sb.append(map[n - 1] - map[s] + map[e]).append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
