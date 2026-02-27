import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 35295 소수가_아닌_수_4
 * 난이도: SILVER4
 * 유형: 수학
 */
class Main_35295 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/26_35295_소수가_아닌_수_4.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if (n == 2 && arr[0] == 1) {
            if (isPrime(arr[1]))
                sb.append("NO");
            else
                sb.append("YES").append("\n").append(2).append("\n").append(arr[0]).append(" ").append(arr[1]);

        }

        else {
            sb.append("YES").append("\n").append(2).append("\n");
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] != 1) {
                    sb.append(arr[i]).append(" ");
                    cnt++;
                }
                if (cnt == 2)
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
