import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 4320 완전_P제곱수
 * 난이도: GOLD5
 * 유형: 수학
 */
class Main_4320 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/13_4320_완전_P제곱수.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        long input;
        while ((input = Long.parseLong(br.readLine())) != 0) {
            long n = input;
            if (n == 0)
                break;

            boolean isNegative = n < 0;
            long target = Math.abs(n);
            int ans = 1;

            // 지수(p)를 32부터 1까지 줄여가며 확인
            for (int p = 32; p >= 1; p--) {
                // 음수인데 지수가 짝수면 불가능하므로 스킵
                if (isNegative && p % 2 == 0)
                    continue;

                // 1. target의 (1/p) 제곱근을 구함
                // Math.pow 대신 이진 탐색이나 근사값 계산 사용 추천
                long root = Math.round(Math.pow(target, 1.0 / p));

                // 2. 다시 p제곱 해서 원래 값과 같은지 검증
                if (Math.pow(root, p) == target) {
                    ans = p;
                    break; // 가장 큰 p부터 찾았으므로 바로 종료
                }
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
