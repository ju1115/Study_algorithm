import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 3181 줄임말_만들기
 * 난이도: BRONZE2
 * 유형: 문자열
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2511/25_3181_줄임말_만들기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        Set<String> uselessSet = Set.of("i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili");
        st = new StringTokenizer(br.readLine());
        determine(uselessSet, 0);
        while (st.hasMoreTokens()) {
            determine(uselessSet, 1);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void determine(Set<String> uselessSet, int idx) {
        String s = st.nextToken();
        if (!uselessSet.contains(s) || idx == 0) {
            s = s.toUpperCase();
            sb.append(s.toCharArray()[0]);
        }
    }
}
