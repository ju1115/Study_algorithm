import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 17362 수학은_체육과목_입니다_2
 * 난이도: BRONZE4
 * 유형: 수학
 */
class Main_17362 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/20_17362_수학은_체육과목_입니다_2.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[] arr = { 2, 1, 2, 3, 4, 5, 4, 3 };
        n %= 8;
        sb.append(arr[n]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
