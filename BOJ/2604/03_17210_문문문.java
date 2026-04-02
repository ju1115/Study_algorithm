import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 17210 문문문
 * 난이도: BRONZE3
 * 유형: 그리디
 */
class Main_17210 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2604/03_17210_문문문.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        long n = Long.parseLong(br.readLine());
        if (n >= 6) {
            sb.append("Love is open door");
        } else {
            int start = Integer.parseInt(br.readLine());
            for (int i = 0; i < n - 1; i++) {
                if (start == 1) {
                    start = 0;
                    sb.append(start).append("\n");
                } else {
                    start = 1;
                    sb.append(start).append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
