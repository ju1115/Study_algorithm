import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 11109 괴짜_교수
 * 난이도: BRONZE3
 * 유형: 구현
 */
class Main_11109 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/31_11109_괴짜_교수.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int pt = d + n * p;
            int st = n * s;
            if (pt == st)
                sb.append("does not matter\n");
            else if (pt < st) {
                sb.append("parallelize\n");
            } else {
                sb.append("do not parallelize\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
