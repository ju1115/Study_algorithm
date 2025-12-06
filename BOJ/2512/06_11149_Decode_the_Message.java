import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 11149 Decode_the_Message
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_11149 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2512/06_11149_Decode_the_Message.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                char[] carr = s.toCharArray();
                int v = 0;
                for (char c : carr) {
                    v += c - 'a';
                }
                v %= 27;
                if (v == 26) {
                    sb.append(" ");
                } else {
                    sb.append(((char) ('a' + v)));
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
