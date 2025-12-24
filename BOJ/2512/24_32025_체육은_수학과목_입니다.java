import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 32025 체육은_수학과목_입니다
 * 난이도: BRONZE4
 * 유형: 수학
 */
class Main_32025 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/24_32025_체육은_수학과목_입니다.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int h = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        int ans = Math.min(h, w);
        sb.append(ans * 100 / 2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
