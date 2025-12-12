import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 14646 욱제는_결정장애야
 * 난이도: SILVER5
 * 유형: 구현
 */
class Main_14646 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/12_14646_욱제는_결정장애야.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            if (set.contains(now)) {
                set.remove(now);
            } else {
                set.add(now);
                ans = Math.max(ans, set.size());
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
