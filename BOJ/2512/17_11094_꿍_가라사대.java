import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 11094 꿍_가라사대
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_11094 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/17_11094_꿍_가라사대.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.startsWith("Simon says")) {
                sb.append(s.substring(11)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
