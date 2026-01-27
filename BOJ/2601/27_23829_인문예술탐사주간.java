import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 23829 인문예술탐사주간
 * 난이도: GOLD4
 * 유형: 이분탐색
 */
class Main_23829 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> arr;
    static long[] prefixSum;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/27_23829_인문예술탐사주간.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        prefixSum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
        }
        arr.sort((o1, o2) -> o1 - o2);
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr.get(i);
        }
        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(br.readLine());
            int idx = binarySearch(n, 0, N);
            long ans = 0;
            ans += ((long) idx * n) - prefixSum[idx];
            ans += (prefixSum[N] - prefixSum[idx]) - ((long) (N - idx) * n);
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int binarySearch(int n, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
