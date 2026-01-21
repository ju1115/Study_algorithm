import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 14645 와이버스_부릉부릉
 * 난이도: BRONZE5
 * 유형: 구현
 */
class Main_14645 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/21_14645_와이버스_부릉부릉.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        sb.append("비와이");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
