import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1864 문어_숫자
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_1864 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[] symbols = { '-', '\\', '(', '@', '?', '>', '&', '%', '/' };

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/27_1864_문어_숫자.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String input;
        while (!(input = br.readLine()).equals("#")) {
            char[] numbers = input.toCharArray();
            int index = numbers.length - 1;
            int num = 0;
            for (char symbol : numbers) {
                int cnt = 0;
                while (true) {
                    if (symbols[cnt] == symbol) {
                        break;
                    }
                    cnt++;
                }
                if (cnt == 8)
                    cnt = -1;
                for (int i = 0; i < index; i++) {
                    cnt *= 8;
                }
                num += cnt;
                index--;
            }
            sb.append(num).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
