import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 12718 Crop_Triangles_(Large)
 * 난이도: GOLD5
 * 유형: 수학
 */
class Main_12718 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2603/13_12718_Crop_Triangles_(Large).txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int N = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= N; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int x0 = Integer.parseInt(st.nextToken());
            int y0 = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] count = new long[9];
            long X = x0, Y = y0;
            count[(int) ((X % 3) * 3 + (Y % 3))]++;
            for (int j = 1; j < n; j++) {
                X = (a * X + b) % m;
                Y = (c * Y + d) % m;
                count[(int) ((X % 3) * 3 + (Y % 3))]++;
            }

            long ans = 0;
            for (int j = 0; j < 9; j++) {
                ans += count[j] * (count[j] - 1) * (count[j] - 2) / 6;
            }

            for (int j = 0; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    for (int l = k + 1; l < 9; l++) {
                        int x1 = j / 3, y1 = j % 3;
                        int x2 = k / 3, y2 = k % 3;
                        int x3 = l / 3, y3 = l % 3;
                        if ((x1 + x2 + x3) % 3 == 0 && (y1 + y2 + y3) % 3 == 0) {
                            ans += count[j] * count[k] * count[l];
                        }
                    }
                }
            }
            sb.append("Case #").append(tc).append(": ").append(ans).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
