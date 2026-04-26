import java.util.*;
import java.io.*;

/**
 * 문제: Programmers 389478 택배_상자_꺼내기
 * 난이도: Lv_1
 * 유형: 구현현
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("Programmers/2604/26_389478_택배_상자_꺼내기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    class Solution {
        public int solution(int n, int w, int num) {
            int answer = 1;
            while (n >= 2 * w + num) {
                num += 2 * w;
                answer += 2;
            }
            int state = num % (2 * w);
            if (state == 0)
                state = 2 * w;
            int plus = 0;
            if (state <= w) {
                plus = (w - state) * 2;
            } else {
                plus = (2 * w - state) * 2;
            }
            if (n >= num + plus + 1)
                answer++;
            return answer;
        }
    }
}
