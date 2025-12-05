import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 23103 Academic_Distance
 * 난이도: BRONZE3
 * 유형: 구현
 */
class Main_23103 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/05_23103_Academic_Distance.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        if (N != 1) {
            st = new StringTokenizer(br.readLine());
            int nowa = Integer.parseInt(st.nextToken());
            int nowb = Integer.parseInt(st.nextToken());
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                ans += Math.abs(nowa - a) + Math.abs(nowb - b);
                nowa = a;
                nowb = b;
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
