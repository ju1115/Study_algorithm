import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 9763 마을의_친밀도
 * 난이도: GOLD5
 * 유형: 브루트포스
 */
class Main_9763 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Dist {
        int to;
        int dist;

        Dist(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/08_9763_마을의_친밀도.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                int dist = Math.abs(arr[i][0] - arr[j][0])
                        + Math.abs(arr[i][1] - arr[j][1])
                        + Math.abs(arr[i][2] - arr[j][2]);
                if (dist < min1) {
                    min2 = min1;
                    min1 = dist;
                } else if (dist < min2) {
                    min2 = dist;
                }
            }
            ans = Math.min(ans, min1 + min2);
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
