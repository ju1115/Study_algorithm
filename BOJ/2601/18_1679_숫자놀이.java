import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1679 숫자놀이
 * 난이도: SILVER1
 * 유형: 그래프
 */
class Main_1679 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/18_1679_숫자놀이.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        for (int i = 0; i < 1001; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())] = 1;
        }
        int k = Integer.parseInt(br.readLine());
        int idx = 2;
        int ans = 0;
        while (true) {
            for (int i = 1; i <= idx / 2; i++) {
                arr[idx] = Math.min(arr[idx], arr[i] + arr[idx - i]);
            }
            // for (int num : arr) {
            // if (idx >= num) {
            // arr[idx] = Math.min(arr[idx], arr[idx - num] + 1);
            // }
            // }
            if (arr[idx] > k) {
                ans = idx;
                break;
            }
            idx++;
        }
        if (ans % 2 == 0) {
            sb.append("holsoon win at ").append(ans);
        } else {
            sb.append("jjaksoon win at ").append(ans);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
