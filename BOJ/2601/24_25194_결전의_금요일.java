import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25194 결전의_금요일
 * 난이도: GOLD5
 * 유형: DP
 */
class Main_25194 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/24_25194_결전의_금요일.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[7];
        arr[0] = true;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int work = Integer.parseInt(st.nextToken()) % 7;
            boolean[] sub = new boolean[7];
            for (int i = 0; i < 7; i++) {
                if (arr[i]) {
                    sub[i] = true;
                    sub[(i + work) % 7] = true;
                }
            }
            arr = sub;
        }
        if (arr[4]) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
