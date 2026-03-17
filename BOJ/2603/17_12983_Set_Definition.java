import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 12983 Set_Definition
 * 난이도: GOLD1
 * 유형: 수학
 */
class Main_12983 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/17_12983_Set_Definition.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int T = Integer.parseInt(br.readLine());
        int[] queries = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            queries[i] = Integer.parseInt(br.readLine());
            if (queries[i] > maxN) {
                maxN = queries[i];
            }
        }
        long[] S = new long[maxN];
        S[0] = 1;
        int p2 = 0;
        int p3 = 0;
        for (int i = 1; i < maxN; i++) {
            long next2 = S[p2] * 2 + 1;
            long next3 = S[p3] * 3 + 1;

            S[i] = Math.min(next2, next3);

            if (S[i] == next2)
                p2++;
            if (S[i] == next3)
                p3++;
        }
        for (int i = 0; i < T; i++) {
            sb.append(S[queries[i] - 1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
