import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 15970 화살표_그리기
 * 난이도: SILVER4
 * 유형: 브루트포스
 */
class Main_15970 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/19_15970_화살표_그리기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> colors = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(b).add(a);
            colors.add(b);
        }
        int ans = 0;
        for (int color : colors) {
            ArrayList<Integer> now = map.get(color);
            Collections.sort(now);
            int size = now.size();
            ans += now.get(size - 1) - now.get(size - 2);
            ans += now.get(1) - now.get(0);
            for (int i = 1; i < now.size() - 1; i++) {
                ans += Math.min(now.get(i) - now.get(i - 1), now.get(i + 1) - now.get(i));
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
