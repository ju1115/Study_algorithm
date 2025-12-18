import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 23899 알고리즘_수업-선택_정렬_5
 * 난이도: BRONZE1
 * 유형: 구현
 */
class Main_23899 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] a, b;
    static int n;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/18_23899_알고리즘_수업-선택_정렬_5.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        boolean ans = false;
        if (compare()) {
            ans = true;
        }
        for (int i = n - 1; i > 0; i--) {
            int idx = find(i);
            if (i != idx) {
                int temp = a[idx];
                a[idx] = a[i];
                a[i] = temp;
            }
            if (compare()) {
                ans = true;
                break;
            }
        }
        if (!ans) {
            sb.append(0);
        } else {
            sb.append(1);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int find(int n) {
        int idx = 0;
        int max = 0;
        for (int i = 0; i <= n; i++) {
            if (max < a[i]) {
                idx = i;
                max = a[i];
            }
        }
        return idx;
    }

    static boolean compare() {
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}
