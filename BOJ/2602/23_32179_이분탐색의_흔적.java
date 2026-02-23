import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 32179 이분탐색의_흔적
 * 난이도: GOLD3
 * 유형: 수학
 */
class Main_32179 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int MOD = 1000000007;
    static long[][] comb = new long[105][105];

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/23_32179_이분탐색의_흔적.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        for (int i = 0; i <= 100; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] binarySearch = new int[k];
        for (int i = 0; i < k; i++) {
            binarySearch[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[n + 1];
        int s = 1;
        int e = n;

        int mid = (s + e) / 2;
        arr[mid] = binarySearch[0];
        int before = binarySearch[0];

        for (int i = 1; i < k; i++) {
            int cur = binarySearch[i];

            if (before > cur) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }

            mid = (s + e) / 2;
            arr[mid] = cur;
            before = cur;
        }

        long ans = 1;
        int startVal = 1;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                cnt++;
            } else {
                int endVal = arr[i] - 1;

                int nPool = endVal - startVal + 1;
                if (cnt > 0) {
                    ans = (ans * comb[nPool][cnt]) % MOD;
                }

                cnt = 0;
                startVal = arr[i] + 1;
            }
        }

        if (cnt > 0) {
            int endVal = 100;
            int nPool = endVal - startVal + 1;
            ans = (ans * comb[nPool][cnt]) % MOD;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
