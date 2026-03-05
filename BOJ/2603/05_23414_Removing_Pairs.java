import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 23414 Removing_Pairs
 * 난이도: SILVER1
 * 유형: 문자열
 */
class Main_23414 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/05_23414_Removing_Pairs.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String s = br.readLine();
        String t = br.readLine();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int sIdx = 0;
        int tIdx = 0;
        boolean find = false;
        while (tIdx < tArr.length) {
            if (sArr[sIdx] == tArr[tIdx] && sIdx % 2 == tIdx % 2) {
                sIdx++;
                tIdx++;
            } else {
                tIdx++;
            }
            if (sIdx == sArr.length) {
                find = true;
                break;
            }
        }
        if ((t.length() - s.length()) % 2 != 0) {
            find = false;
        }
        if (find) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
