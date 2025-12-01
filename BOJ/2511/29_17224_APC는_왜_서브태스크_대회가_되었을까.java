import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 17224 APC는_왜_서브태스크_대회가_되었을까?
 * 난이도: BRONZE1
 * 유형: 그리디
 */
class Main_17224 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int ans;
    static int K;

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2511/29_17224_APC는_왜_서브태스크_대회가_되었을까?.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;
        ArrayList<Integer> qArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sub1 = Integer.parseInt(st.nextToken());
            int sub2 = Integer.parseInt(st.nextToken());
            if (K == 0)
                continue;
            if (sub2 <= L) {
                solveSub2();
            } else if (sub1 > L) {
                continue;
            } else {
                qArr.add(sub1);
            }
        }
        if (K != 0) {
            ans += Math.min(K, qArr.size()) * 100;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solveSub1() {
        ans += 100;
        K--;
    }

    static void solveSub2() {
        ans += 140;
        K--;
    }
}
