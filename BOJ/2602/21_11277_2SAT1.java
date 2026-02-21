import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 11277 2SAT1
 * 난이도: SILVER1
 * 유형: 브루트포스
 */
class Main_11277 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/21_11277_2SAT1.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] clauses = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            clauses[i][0] = Integer.parseInt(st.nextToken());
            clauses[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean possible = false;
        for (int i = 0; i < (1 << n); i++) {
            boolean[] values = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    values[j + 1] = true;
                }
            }

            boolean allTrue = true;
            for (int j = 0; j < m; j++) {
                boolean first = clauses[j][0] > 0 ? values[clauses[j][0]] : !values[-clauses[j][0]];
                boolean second = clauses[j][1] > 0 ? values[clauses[j][1]] : !values[-clauses[j][1]];
                if (!(first || second)) {
                    allTrue = false;
                    break;
                }
            }

            if (allTrue) {
                possible = true;
                break;
            }
        }

        sb.append(possible ? 1 : 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
