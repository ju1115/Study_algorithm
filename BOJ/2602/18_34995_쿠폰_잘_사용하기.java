import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 34995 쿠폰_잘_사용하기
 * 난이도: SILVER5
 * 유형: 문자열
 */
class Main_34995 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/18_34995_쿠폰_잘_사용하기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();
        s = s.replace("?", "9");
        String input = br.readLine();
        if (input.length() > n) {
            sb.append(-1);
        } else if (input.length() < n) {
            sb.append(s);
        } else {
            if (s.compareTo(input) >= 0) {
                sb.append(s);
            } else {
                sb.append(-1);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
