import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 32628 두_스택
 * 난이도: SILVER3
 * 유형: 그리디
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/26_32628_두_스택.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[n];
        long aSize = 0;
        long bSize = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            aSize += a[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            bSize += b[i];
        }
        int aIdx = n - 1;
        int bIdx = n - 1;
        for (int i = k; i > 0; i--) {
            if (aSize > bSize) {
                aSize -= a[aIdx];
                aIdx--;
            } else if (aSize < bSize) {
                bSize -= b[bIdx];
                bIdx--;
            } else {
                if (aSize == 0)
                    break;
                if (a[aIdx] > b[bIdx]) {
                    aSize -= a[aIdx];
                    aIdx--;
                } else {
                    bSize -= b[bIdx];
                    bIdx--;
                }
            }
        }
        sb.append(Math.max(aSize, bSize));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
