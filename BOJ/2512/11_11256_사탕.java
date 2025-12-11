import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 11256 사탕
 * 난이도: SILVER5
 * 유형: 그리디
 */
class Main_11256 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/11_11256_사탕.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr.add(r * c);
            }
            int ans = 0;
            Collections.sort(arr);
            for (int i = arr.size() - 1; i > 0; i--) {
                j -= arr.get(i);
                ans++;
                if (j <= 0)
                    break;
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
