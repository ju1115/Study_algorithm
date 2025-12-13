import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 18310 안테나
 * 난이도: SILVER3
 * 유형: 수학
 */
class Main_18310 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/13_18310_안테나.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = n % 2 == 1 ? arr[n / 2] : arr[n / 2 - 1];
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
