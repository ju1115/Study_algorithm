import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 5704 팬그램
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_5704 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/14_5704_팬그램.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String input;
        while (!(input = br.readLine()).equals("*")) {
            st = new StringTokenizer(input);
            boolean[] isUsed = new boolean[26];
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                for (char c : str.toCharArray()) {
                    isUsed[c - 'a'] = true;
                }
            }
            int cnt = 0;
            for (int i = 0; i < 26; ++i) {
                if (isUsed[i])
                    cnt++;
            }
            if (cnt == 26)
                sb.append("Y\n");
            else
                sb.append("N\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
