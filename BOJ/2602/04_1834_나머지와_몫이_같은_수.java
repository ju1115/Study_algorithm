import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1834 나머지와_몫이_같은_수
 * 난이도: BRONZE1
 * 유형: 수학
 */
class Main_1834 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/04_1834_나머지와_몫이_같은_수.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        long n = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans += i * n + i;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
