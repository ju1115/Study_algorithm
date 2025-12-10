import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 11444 피보나치_수_6
 * 난이도: GOLD2
 * 유형: 수학
 */
class Main_11444 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long mod = 1000000007;
    static long[][] ans;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/09_11444_피보나치_수_6.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        long n = Long.parseLong(br.readLine());
        if (n == 0)
            sb.append(0);
        else if (n == 1)
            sb.append(1);
        else {
            ans = new long[2][2];
            ans[0][0] = 1;
            ans[0][1] = 1;
            ans[1][0] = 1;
            sb.append(solve(n)[1][0]);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static long[][] solve(long n) {
        if (n == 1) {
            return ans;
        }
        if (n % 2 == 0) {
            long[][] temp = solve(n / 2);
            return time(temp, temp);
        } else {
            return time(solve(n - 1), solve(1));
        }
    }

    static long[][] time(long[][] a, long[][] b) {
        long[][] arr = new long[2][2];
        arr[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0])) % mod;
        arr[0][1] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1])) % mod;
        arr[1][0] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0])) % mod;
        arr[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1])) % mod;
        return arr;
    }
}
