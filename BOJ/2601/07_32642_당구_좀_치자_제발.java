import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 32642 당구_좀_치자_제발
 * 난이도: BRONZE4
 * 유형: 수학
 */
class Main_32642 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/07_32642_당구_좀_치자_제발.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        st = new StringTokenizer(br.readLine());
        int rage = 0;
        for (int i = 0; i < n; ++i) {
            int rain = Integer.parseInt(st.nextToken());
            if (rain == 0) {
                rage--;
            } else {
                rage++;
            }
            ans += rage;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
