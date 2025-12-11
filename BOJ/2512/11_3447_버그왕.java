import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 3447 버그왕
 * 난이도: BRONZE1
 * 유형: 문자열
 */
class Main_3447 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2512/11_3447_버그왕.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String input;

        while ((input = br.readLine()) != null) {

            while (input.contains("BUG")) {
                input = input.replace("BUG", "");
            }

            sb.append(input).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
