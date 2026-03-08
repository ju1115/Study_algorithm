import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 30826 그_긴_수
 * 난이도: GOLD2
 * 유형: 수학
 */
class Main_30826 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/08_30826_그_긴_수.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        long k = Long.parseLong(br.readLine());
        long L = 1;
        long count = 9;
        long halfLen = 1;

        while (true) {
            long totalDigitsInL = L * count;

            if (k <= totalDigitsInL) {
                break;
            }

            k -= totalDigitsInL;
            L++;
            halfLen = (L + 1) / 2;
            count = 9 * pow10(halfLen - 1);
        }

        long pIdx = (k - 1) / L;
        long dIdx = (k - 1) % L;

        long startNumber = pow10(halfLen - 1);
        long targetHalf = startNumber + pIdx;

        if (dIdx >= halfLen) {
            dIdx = L - 1 - dIdx;
        }

        String halfStr = String.valueOf(targetHalf);
        sb.append(halfStr.charAt((int) dIdx));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static long pow10(long exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= 10;
        }
        return result;
    }
}
