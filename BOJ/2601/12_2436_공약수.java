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

    static class multiple {
        int left;
        int right;
        int sum;

        multiple(int left, int right) {
            this.left = left;
            this.right = right;
            this.sum = left + right;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2601/12_2436_공약수.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int val = b / a;
        PriorityQueue<multiple> pq = new PriorityQueue<>((a1, a2) -> {
            return a1.sum - a2.sum;
        });
        for (int i = 1; i < Math.sqrt(val); i++) {
            if (val % i == 0) {
                int left = i;
                int right = val / i;
                if (gcd(left, right))
                    pq.add(new multiple(left, right));
            }
        }
        multiple first = pq.poll();
        int left = first.left * a;
        int right = first.right * a;
        sb.append(left).append(" ").append(right);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static boolean gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
            if (a == 1)
                return true;
        }
        return false;

    }
}
