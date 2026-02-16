import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 23845 마트료시카
 * 난이도: GOLD3
 * 유형: 그리디
 */
class Main_23845 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/15_23845_마트료시카.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        long ans = 0;
        int idx = list.size() - 1;
        while (idx >= 0) {
            int num = list.get(idx);
            int count = 0;
            for (int i = 0; i <= idx; i++) {
                int next = idx - i;
                int nnum = list.get(next);
                if (num - nnum == i && map.get(nnum) > 0) {
                    map.put(nnum, map.get(nnum) - 1);
                    count++;
                } else {
                    break;
                }
            }
            ans += (long) count * num;
            for (int i = idx; i >= 0; i--) {
                if (map.get(list.get(i)) > 0) {
                    idx = i;
                    break;
                }
                if (i == 0) {
                    idx = -1;
                    break;
                }
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
