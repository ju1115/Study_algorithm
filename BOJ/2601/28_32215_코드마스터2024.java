import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 32215 코드마스터2024
 * 난이도: BRONZE4
 * 유형: 구현
 */
class Main_32215 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/28_32215_코드마스터2024.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        sb.append(m * k + m);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
