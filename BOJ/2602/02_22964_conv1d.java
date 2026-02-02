import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 22964 conv1d
 * 난이도: GOLD3
 * 유형: 수학
 */
class Main_22964 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static long MOD = 998244353; // long으로 변경

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/02_22964_conv1d.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long X = Integer.parseInt(st.nextToken());

        long s = X * (X + 1) / 2 % MOD;

        long baseTerm = s * s % MOD;
        long ans = baseTerm * k % MOD;

        ans = (ans * pow(X, n + k - 2)) % MOD;

        for (int i = 0; i < n - k + 1; i++) {
            sb.append(ans).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static long pow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}