import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 6609 모기곱셈
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_6609 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/01_6609_모기곱셈.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            while (n > 0) {
                int nm = p / s;
                int np = l / r;
                int nl = m * e;
                m = nm;
                p = np;
                l = nl;
                n--;
            }
            sb.append(m).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
