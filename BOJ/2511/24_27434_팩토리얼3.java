import java.util.*;
import java.io.*;
import java.math.BigInteger;

/**
 * 문제: BOJ 27434 팩토리얼3
 * 난이도: BRONZE5
 * 유형: 큰수 연산
 */
class Main_27434 {
    public static void main(String[] args) throws IOException {
        // 입력 속도를 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // N이 0일 때 팩토리얼은 1입니다. (예외 처리)
        if (N == 0) {
            bw.write("1");
        } else {
            // 분할 정복으로 팩토리얼 계산
            bw.write(factorial(1, N).toString());
        }

        bw.flush();
        bw.close();
    }

    // [핵심] 분할 정복 함수
    // 1부터 N까지 한 번에 곱하는 게 아니라, 반씩 쪼개서 곱합니다.
    public static BigInteger factorial(int start, int end) {
        // 범위에 숫자가 1개만 남으면 그 숫자를 반환 (Base Case)
        if (start == end) {
            return BigInteger.valueOf(start);
        }

        // 범위를 절반으로 나눔
        int mid = (start + end) / 2;

        // 왼쪽 부분 곱 * 오른쪽 부분 곱
        return factorial(start, mid).multiply(factorial(mid + 1, end));
    }
}