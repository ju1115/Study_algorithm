import java.util.*;
import java.io.*;
import java.math.BigInteger;

/**
 * 문제: BOJ 29665 Награды
 * 난이도: GOLD3
 * 유형: 수학
 */
class Main_29665 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/16_29665_Награды.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int N = n - k + 1;
        if (N < k) {
            bw.write("0\n");
            bw.flush();
            return;
        }

        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        for (int i = 0; i < k; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(N - i));
            denominator = denominator.multiply(BigInteger.valueOf(i + 1));
        }

        BigInteger comb = numerator.divide(denominator);

        BigInteger ans = comb.remainder(BigInteger.valueOf(m));

        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
