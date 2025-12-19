import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 11896 다각형
 * 난이도: SILVER5
 * 유형: 수학
 */
class Main_11896 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/19_11896_다각형.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n < 3)
            n = 3;
        if (m < 3)
            m = 3;
        long a = (n - 1) / 2;
        long b = m / 2;
        long ans = b * (b + 1) - a * (a + 1);
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
