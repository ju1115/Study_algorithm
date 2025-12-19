import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2422 한윤정이_이탈리아에_가서_아이스크림을_사먹는데
 * 난이도: SILVER4
 * 유형: 브루트포스
 */
class Main_2422 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, ans;
    static int[] arr = new int[3];
    static HashMap<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2512/19_2422_한윤정이_이탈리아에_가서_아이스크림을_사먹는데.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                map.get(b).add(a);
            } else {
                map.get(a).add(b);
            }
        }
        ans = 0;
        solve(0, 0);
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve(int k, int idx) {
        if (idx == 3) {
            int now1 = arr[0];
            int now2 = arr[1];
            int now3 = arr[2];
            if (!map.get(now1).contains(now2) && !map.get(now1).contains(now3) && !map.get(now2).contains(now3)) {
                ans++;
            }
            return;
        }
        for (int i = k + 1; i <= n; i++) {
            arr[idx] = i;
            solve(i, idx + 1);
        }
    }
}
