import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 6003 Claustrophobic_Cows
 * 난이도: BRONZE1
 * 유형: 브루트포스
 */
class Main_6003 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Coor {
        long x;
        long y;

        Coor(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2512/06_6003_Claustrophobic_Cows.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int N = Integer.parseInt(br.readLine());
        ArrayList<Coor> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Coor(x, y));
        }
        long ans = Long.MAX_VALUE;
        int ansX = 0;
        int ansY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                Coor ci = arr.get(i);
                Coor cj = arr.get(j);
                long v = (ci.x - cj.x) * (ci.x - cj.x) + (ci.y - cj.y) * (ci.y - cj.y);
                if (v < ans) {
                    ans = v;
                    ansX = Math.min(i, j) + 1;
                    ansY = Math.max(i, j) + 1;
                }
            }
        }
        sb.append(ansX + " " + ansY);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
