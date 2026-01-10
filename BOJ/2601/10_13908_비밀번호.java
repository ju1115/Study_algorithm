import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 13908 비밀번호
 * 난이도: SILVER2
 * 유형: 브루트포스
 */
class Main_13908 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k;
    static int[] arr;
    static boolean[] isRequired = new boolean[10];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/10_13908_비밀번호.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        if (k > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                isRequired[Integer.parseInt(st.nextToken())] = true;
            }
        }

        solve(0);
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void solve(int depth) {
        if (depth == n) {
            for (int i = 0; i < 10; i++) {
                if (isRequired[i]) {
                    boolean found = false;
                    for (int val : arr) {
                        if (val == i) {
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        return;
                }
            }
            ans++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            arr[depth] = i;
            solve(depth + 1);
        }
    }
}
