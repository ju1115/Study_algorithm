import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 12845 모두의_마블
 * 난이도: SILVER3
 * 유형: 그리디
 */
class Main_12845 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/10_12845_모두의_마블.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            if (max < num) {
                max = num;
            }
        }
        sb.append(sum + (n - 2) * max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
