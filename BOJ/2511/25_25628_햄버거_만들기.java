import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25628 햄버거_만들기
 * 난이도: BRONZE4
 * 유형: 수학
 */
class Main_25628 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2511/25_25628_햄버거_만들기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken().toString());
        int b = Integer.parseInt(st.nextToken().toString());
        a = a / 2;
        sb.append(Math.min(a, b));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
