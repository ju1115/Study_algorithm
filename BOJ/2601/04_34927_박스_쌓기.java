import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 34927 박스_쌓기
 * 난이도: SILVER3
 * 유형: 그리디
 */
class Main_34927 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/04_34927_박스_쌓기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = 0;
        int idx = 0;
        int weight = 0;
        while (idx < n) {
            if (weight <= arr[idx]) {
                weight += arr[idx];
                ans++;
            }
            idx++;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
