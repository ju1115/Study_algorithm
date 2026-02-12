import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 15735 삼각
 * 난이도: SILVER3
 * 유형: 수학
 */
class Main_15735 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/11_15735_삼각.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n + 1];
        // arr[1] = 1;
        // for (int i = 1; i < n; i++) {
        // arr[i + 1] = arr[i] + 2 * i + 1 + (n * (n + 1)) / 2;
        // }
        sb.append(((long) n * (n + 2) * (2 * n + 1)) / 8);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
