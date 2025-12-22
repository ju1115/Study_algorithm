import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1284 집_주소
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_1284 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2512/22_1284_집_주소.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int[] arr = { 4, 2, 3, 3, 3, 3, 3, 3, 3, 3 };
        String input;

        while (!(input = br.readLine()).equals("0")) {
            int ans = 2;
            char[] carr = input.toCharArray();
            for (char c : carr) {
                int block = c - '0';
                ans += arr[block];
            }
            ans += carr.length - 1;
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
