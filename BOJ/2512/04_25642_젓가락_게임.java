import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25642 젓가락_게임
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_25642 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/04_25642_젓가락_게임.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        while (true) {
            B += A;
            if (B >= 5) {
                sb.append("yt");
                break;
            }
            A += B;
            if (A >= 5) {
                sb.append("yj");
                break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
