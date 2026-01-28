import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 27941 하이퍼_가지_따기
 * 난이도: SILVER2
 * 유형: 구현
 */
class Main_27941 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/28_27941_하이퍼_가지_따기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int[] result = new int[11];
        for (int i = 0; i < 2047; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 11; j++) {
                int num = Integer.parseInt(st.nextToken());
                // 해당 차원의 값에 계속 XOR 연산을 누적
                result[j] ^= num;
            }
        }

        for (int val : result) {
            sb.append(val).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}