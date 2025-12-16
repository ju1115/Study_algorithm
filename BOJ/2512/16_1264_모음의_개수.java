import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1264 모음의_개수
 * 난이도: BRONZE4
 * 유형: 구현
 */
class Main_1264 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/16_1264_모음의_개수.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        char[] gather = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        String input;
        while (!(input = br.readLine()).equals("#")) {
            int ans = 0;
            for (char c : input.toCharArray()) {
                for (char g : gather) {
                    if (c == g) {
                        ans++;
                        break;
                    }
                }
            }
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
