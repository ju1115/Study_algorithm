import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2436 공약수
 * 난이도: GOLD5
 * 유형: 브루트포스
 */
class Main_2436 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/12_2436_공약수.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken()); // 최대공약수
        int l = Integer.parseInt(st.nextToken()); // 최소공배수

        // 두 수의 곱 = G * L
        // 우리가 구할 두 수를 A, B라고 하면 A*B = G*L
        // A = g*a, B = g*b (a, b는 서로소)라고 가정
        // g*a * g*b = g*L => a*b = L/g

        long div = l / g;

        long a = 0;
        long b = 0;

        // 핵심 로직: 제곱근부터 1까지 내려가며 탐색
        // 가장 먼저 발견되는 서로소(coprime) 쌍이 합이 최소임 (중심에 가장 가까우므로)
        for (long i = (long) Math.sqrt(div); i >= 1; i--) {
            if (div % i == 0) { // 약수라면
                long pair = div / i;

                // 두 수가 서로소인지 확인
                if (getGcd(i, pair) == 1) {
                    a = i * g;
                    b = pair * g;
                    break; // 찾자마자 종료 (최적해 보장)
                }
            }
        }

        sb.append(a + " " + b);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 표준 유클리드 호제법
    public static long getGcd(long a, long b) {
        while (b > 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
