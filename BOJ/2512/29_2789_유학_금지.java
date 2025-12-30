import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2789 유학_금지
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_2789 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/29_2789_유학_금지.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String input = br.readLine();
        HashSet<Character> set = new HashSet<>();
        set.add('C');
        set.add('A');
        set.add('M');
        set.add('B');
        set.add('R');
        set.add('I');
        set.add('D');
        set.add('G');
        set.add('E');
        for (char c : input.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
