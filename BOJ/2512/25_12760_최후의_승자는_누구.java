import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 12760 최후의_승자는_누구
 * 난이도: SILVER5
 * 유형: 구현
 */
class Main_12760 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/25_12760_최후의_승자는_누구.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list[i]);
        }
        int[] score = new int[n + 1];
        for (int i = m - 1; i >= 0; i--) {
            int max = 0;
            for (int j = 1; j <= n; j++) {
                if (list[j].get(i) > max) {
                    max = list[j].get(i);
                }
            }
            for (int j = 1; j <= n; j++) {
                if (list[j].get(i) == max) {
                    score[j]++;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int j = 1; j <= n; j++) {
            if (score[j] > max) {
                max = score[j];
            }
        }
        for (int j = 1; j <= n; j++) {
            if (score[j] == max) {
                ans.add(j);
            }
        }
        for (int j = 0; j < ans.size(); j++) {
            sb.append(ans.get(j)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
