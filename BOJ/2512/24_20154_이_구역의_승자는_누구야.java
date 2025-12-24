import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 20154 이_구역의_승자는_누구야
 * 난이도: BRONZE1
 * 유형: 문자열
 */
class Main_20154 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/24_20154_이_구역의_승자는_누구야.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String s = br.readLine();
        char[] carr = s.toCharArray();
        int[] arr = new int[carr.length];
        int idx = 0;
        int[] sarr = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 };
        for (char c : carr) {
            arr[idx++] = sarr[c - 'A'];
        }
        while (true) {
            int[] newArr = new int[arr.length / 2 + arr.length % 2];
            for (int i = 0; i < arr.length; i += 2) {
                if (i + 1 < arr.length) {
                    newArr[i / 2] = (arr[i] + arr[i + 1]) % 10;
                } else {
                    newArr[i / 2] = arr[i] % 10;
                }
            }
            arr = newArr;
            if (arr.length == 1) {
                if (arr[0] % 2 == 1) {
                    sb.append("I'm a winner!");
                } else {
                    sb.append("You're the winner?");
                }
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
