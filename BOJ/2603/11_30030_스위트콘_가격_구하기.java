import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 30030 스위트콘_가격_구하기
 * 난이도: BRONZE5
 * 유형: 수학
 */
class Main_30030 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2603/11_30030_스위트콘_가격_구하기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        n /= 11;
        n *= 10;
        sb.append(n);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
