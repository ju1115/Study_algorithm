import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 9698 SAHUR_IMSA
 * 난이도: BRONZE3
 * 유형: 수학
 */
class Main_9698 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2511/26_9698_SAHUR_IMSA.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int N = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= N; tc++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if ((m + 15) / 60 != 1)
                h--;
            if (h == -1)
                h = 23;
            m += 15;
            m %= 60;
            sb.append("Case #").append(tc).append(": ").append(h).append(" ").append(m).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
