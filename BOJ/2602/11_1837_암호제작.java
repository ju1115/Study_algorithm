import java.util.*;
import java.io.*;
import java.math.BigInteger;

/**
 * 문제: BOJ 1837 암호제작
 * 난이도: BRONZE3
 * 유형: 수학
 */
class Main_1837 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/11_1837_암호제작.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] primes = new boolean[k];
        for (int i = 2; i * i < k; i++) {
            if (!primes[i]) {
                for (int j = i * i; j < k; j += i) {
                    primes[j] = true;
                }
            }
        }
        boolean isBad = false;
        int prime = 0;
        for (int i = 2; i < k; i++) {
            if (!primes[i])
                if (p.remainder(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                    isBad = true;
                    prime = i;
                    break;
                }
        }
        if (!isBad) {
            sb.append("GOOD");
        } else {
            sb.append("BAD ").append(prime);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
