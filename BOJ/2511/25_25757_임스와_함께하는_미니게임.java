import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25757 임스와_함께하는_미니게임
 * 난이도: SILVER5
 * 유형: 문자열
 */
class Main_25757 {
    enum Type {
        Y(1), F(2), O(3);

        private final int score;

        Type(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2511/25_25757_임스와_함께하는_미니게임.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Type type = Type.valueOf(st.nextToken());
        Set<String> userSet = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            userSet.add(br.readLine());
        }
        sb.append(userSet.size() / type.getScore());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
