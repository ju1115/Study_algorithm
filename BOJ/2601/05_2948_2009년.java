import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2948 2009년
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_2948 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/05_2948_2009년.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] day = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int totalDay = 0;
        for (int i = 0; i < m - 1; ++i) {
            totalDay += month[i];
        }
        totalDay += d - 1;
        sb.append(day[(totalDay + 3) % 7]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
