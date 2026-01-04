import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

/**
 * 문제: BOJ 11497 통나무_건너뛰기
 * 난이도: SILVER1
 * 유형: 그리디
 */
class Main_11497 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/04_11497_통나무_건너뛰기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i -= 2) {
                dq.addFirst(arr[i]);
            }
            for (int i = n - 2; i >= 0; i -= 2) {
                dq.addLast(arr[i]);
            }
            List<Integer> list = new ArrayList<>(dq);
            int ans = Math.abs(list.get(n - 1) - list.get(0));
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, Math.abs(list.get(i) - list.get(i - 1)));
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
