import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 24370 알고리즘_수업_점근적_표기6
 * 난이도: SILVER6
 * 유형: 구현
 */
class Main_24370 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/29_24370_알고리즘_수업_점근적_표기6.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int a3 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int n0 = Integer.parseInt(br.readLine());

        // 1. f(n) >= c1 * n^2 확인 -> (a1-c1)n^2 + a2*n + a3 >= 0
        boolean condition1 = isAlwaysPositive(a1 - c1, a2, a3, n0);

        // 2. f(n) <= c2 * n^2 확인 -> (c2-a1)n^2 - a2*n - a3 >= 0
        boolean condition2 = isAlwaysPositive(c2 - a1, -a2, -a3, n0);

        if (condition1 && condition2) {
            sb.append("1");
        } else {
            sb.append("0");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean isAlwaysPositive(int A, int B, int C, int n0) {
        // Case 1: 최고차항 계수가 음수면 언젠가 -무한대로 떨어짐 (Fail)
        if (A < 0)
            return false;

        // Case 2: 최고차항 계수가 0인 경우 (1차 함수 혹은 상수 함수)
        if (A == 0) {
            if (B < 0)
                return false; // 기울기가 음수면 언젠가 음수 (Fail)
            if (B == 0)
                return C >= 0; // 상수 함수면 C가 양수여야 함
            // 기울기가 양수면 n0일 때만 확인하면 됨 (계속 증가하므로)
            return (long) A * n0 * n0 + (long) B * n0 + C >= 0;
        }

        // Case 3: 최고차항 계수가 양수 (아래로 볼록 2차 함수)
        // 꼭지점의 x좌표: -B / (2A)
        double vertexX = -B / (2.0 * A);

        // n0일 때의 함수값 확인
        long valueAtN0 = (long) A * n0 * n0 + (long) B * n0 + C;

        if (vertexX <= n0) {
            // 꼭지점이 n0보다 왼쪽에 있으면, n0 이후로는 계속 증가함
            // 따라서 n0일 때 값만 0 이상이면 통과
            return valueAtN0 >= 0;
        } else {
            // 꼭지점이 n0보다 오른쪽에 있으면, 꼭지점에서 최소값을 가짐
            // 꼭지점에서의 함숫값 = C - B^2 / (4A) (판별식 활용)
            // 부동소수점 오차 방지를 위해 판별식 D로 계산: 4AC - B^2 >= 0 이어야 함
            // 하지만 간단히 double로 계산해도 문제 범위 내에선 충분
            double valueAtVertex = A * vertexX * vertexX + B * vertexX + C;
            return valueAtVertex >= 0;
        }
    }
}
