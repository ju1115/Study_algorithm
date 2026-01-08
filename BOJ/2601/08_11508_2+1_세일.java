import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 11508 2+1_세일
 * 난이도: SILVER4
 * 유형: 그리디
 */
class Main_11508 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/08_11508_2+1_세일.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
            ans += arr[i];
        }
        Arrays.sort(arr);
        for (int i = n - 3; i >= 0; i -= 3) {
            ans -= arr[i];
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
