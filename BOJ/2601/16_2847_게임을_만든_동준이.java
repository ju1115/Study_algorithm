import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2847 게임을_만든_동준이
 * 난이도: SILVER4
 * 유형: 그리디
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/16_2847_게임을_만든_동준이.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int next = arr[n - 1];
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            int num = arr[i];
            if (num >= next) {
                int v = num - next + 1;
                ans += v;
                next = next - 1;
            } else {
                next = num;
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
