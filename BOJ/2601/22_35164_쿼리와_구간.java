import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 35164 쿼리와_구간
 * 난이도: SILVER2
 * 유형: 쿼리
 */
class Main_35164 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/22_35164_쿼리와_구간.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] query = new int[m];
        for (int i = 0; i < m; i++) {
            query[i] = Integer.parseInt(br.readLine());
        }

        if (n == 2) {
            boolean shift = false;
            int before = -1;
            for (int i = 0; i < m; i++) {
                if (before == -1) {
                    before = query[i];
                    continue;
                }
                if (before != query[i]) {
                    shift = !shift;
                    break;
                }
            }
            if (shift)
                sb.append(-1);
            else {
                sb.append(1).append("\n");
                if (query[0] == 0) {
                    sb.append("1 -1 1\n").append("1 1 2\n");
                } else {
                    sb.append("1 -1 1\n").append("1 0 2\n");
                }
                for (int i = 0; i < m; i++) {
                    sb.append("2 1 2\n");
                }
            }
        } else {
            sb.append(1).append("\n");
            sb.append("1 -1 1\n").append("1 3 4\n").append("1 0 2\n");
            for (int i = 0; i < n - 3; i++) {
                sb.append("1 10 11\n");
            }
            for (int i = 0; i < m; i++) {
                if (query[i] == 0) {
                    sb.append("2 1 2\n");
                } else {
                    sb.append("2 1 3\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
