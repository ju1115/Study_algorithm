import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 11566 킥
 * 난이도: SILVER3
 * 유형: 브루트포스
 */
class Main_11566 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/19_11566_킥.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] target = new int[m];
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        int minGap = Integer.MAX_VALUE;
        int maxGap = -1;

        for (int gap = 0; gap < m; gap++) {
            for (int start = 0; start < m; start++) {
                boolean possible = true;
                for (int k = 0; k < n; k++) {
                    int idx = start + k * (gap + 1);
                    if (idx >= m || target[idx] != arr[k]) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    minGap = Math.min(minGap, gap);
                    maxGap = Math.max(maxGap, gap);
                }
            }
        }

        if (maxGap == -1) {
            sb.append(-1);
        } else {
            sb.append(minGap).append(" ").append(maxGap);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
