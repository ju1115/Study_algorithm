import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 6750 Rotating_letters
 * 난이도: BRONZE3
 * 유형: 문자열
 */
class Main_6750 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/09_6750_Rotating_letters.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        HashSet<Character> set = new HashSet<>();
        set.add('I');
        set.add('O');
        set.add('S');
        set.add('H');
        set.add('Z');
        set.add('X');
        set.add('N');
        char[] carr = br.readLine().toCharArray();
        boolean isWrong = false;
        for (char c : carr) {
            if (!set.contains(c))
                isWrong = true;
        }
        if (isWrong) {
            sb.append("NO");
        } else {
            sb.append("YES");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
