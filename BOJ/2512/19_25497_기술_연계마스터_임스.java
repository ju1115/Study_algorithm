import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25497 기술_연계마스터_임스
 * 난이도: SILVER5
 * 유형: 구현
 */
class Main_25497 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/19_25497_기술_연계마스터_임스.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] carr = s.toCharArray();
        int[] arr = new int[2];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = carr[i];
            if (0 < c - '0' && c - '0' < 10) {
                ans++;
            } else {
                if (c == 'L') {
                    arr[0]++;
                }
                if (c == 'S') {
                    arr[1]++;
                }
                if (c == 'R') {
                    if (arr[0] == 0) {
                        break;
                    } else {
                        arr[0]--;
                        ans++;
                    }
                }
                if (c == 'K') {
                    if (arr[1] == 0) {
                        break;
                    } else {
                        arr[1]--;
                        ans++;
                    }
                }

            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
