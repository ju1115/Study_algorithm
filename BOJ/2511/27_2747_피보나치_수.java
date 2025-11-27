import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2747 피보나치_수
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_2747 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2511/27_2747_피보나치_수.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int[] fibonaci = new int[46];
        fibonaci[0] = 0;
        fibonaci[1] = 1;
        for (int i = 2; i < 46; i++) {
            fibonaci[i] = fibonaci[i - 1] + fibonaci[i - 2];
        }
        int N = Integer.parseInt(br.readLine());
        sb.append(fibonaci[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
