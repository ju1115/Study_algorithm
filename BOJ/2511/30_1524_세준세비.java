import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 1524 세준세비
 * 난이도: BRONZE1
 * 유형: 구현
 */
class Main_1524 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2511/30_1524_세준세비.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> nArr = new ArrayList<>();
            ArrayList<Integer> mArr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nArr.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                mArr.add(Integer.parseInt(st.nextToken()));
            }
            nArr.sort((a, b) -> {
                return a - b;
            });
            mArr.sort((a, b) -> {
                return a - b;
            });
            ArrayDeque<Integer> nDeque = new ArrayDeque<>();
            ArrayDeque<Integer> mDeque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                nDeque.addLast(nArr.get(i));
            }
            for (int i = 0; i < m; i++) {
                mDeque.addLast(mArr.get(i));
            }
            while (nDeque.size() > 0 && mDeque.size() > 0) {
                int nMin = nDeque.peekFirst();
                int mMin = mDeque.peekFirst();
                if (nMin >= mMin) {
                    mDeque.pollFirst();
                } else {
                    nDeque.pollFirst();
                }
            }
            if (mDeque.size() == nDeque.size()) {
                sb.append("C").append("\n");
            } else if (mDeque.size() == 0) {
                sb.append("S").append("\n");
            } else {
                sb.append("B").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
