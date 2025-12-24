import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25400 제자리
 * 난이도: BRONZE1
 * 유형: 그리디
 */
class Main_25400 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/24_25400_제자리.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int now = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == now) {
                now++;
            } else {
                ans++;
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
