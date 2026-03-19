import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 9935 문자열_폭발
 * 난이도: GOLD4
 * 유형: 문자열
 */
class Main_9935 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/19_9935_문자열_폭발.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String input = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));

            if (sb.length() >= bombLen) {
                boolean isMatch = true;

                for (int j = 0; j < bombLen; j++) {
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            sb.append("FRULA");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
