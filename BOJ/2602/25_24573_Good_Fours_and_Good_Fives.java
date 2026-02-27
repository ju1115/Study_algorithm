import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 24573 Good_Fours_and_Good_Fives
 * 난이도: BRONZE1
 * 유형: 브루트포스
 */
class Main_24573 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2602/25_24573_Good_Fours_and_Good_Fives.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] arr = new int[1000001];
        arr[4] = 1;
        arr[5] = 1;
        for (int i = 20; i <= 1000000; i += 20) {
            arr[i] = 1 + i / 20;
        }
        for (int i = 6; i <= n; i++) {
            arr[i] = Math.max(arr[i - 4], Math.max(arr[i - 5], arr[i]));
        }
        sb.append(arr[n]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
