import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2966 찍기
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_2966 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/06_2966_찍기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        String a = "ABC";
        String b = "BABC";
        String g = "CCAABB";
        char[] input = br.readLine().toCharArray();
        int ac = 0, bc = 0, gc = 0;
        for (int i = 0; i < n; i++) {
            if (input[i] == a.charAt(i % a.length())) {
                ac++;
            }
            if (input[i] == b.charAt(i % b.length())) {
                bc++;
            }
            if (input[i] == g.charAt(i % g.length())) {
                gc++;
            }
        }
        int max = Math.max(ac, Math.max(bc, gc));
        sb.append(max).append("\n");
        if (max == ac) {
            sb.append("Adrian").append("\n");
        }
        if (max == bc) {
            sb.append("Bruno").append("\n");
        }
        if (max == gc) {
            sb.append("Goran").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
