import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 18232 텔레포트_정거장
 * 난이도: SILVER2
 * 유형: 그래프
 */
class Main_18232 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/19_18232_텔레포트_정거장.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        arr[s] = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(s);
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            if (0 < cur - 1 && arr[cur - 1] > arr[cur] + 1) {
                arr[cur - 1] = arr[cur] + 1;
                dq.add(cur - 1);
            }
            if (cur + 1 <= n && arr[cur + 1] > arr[cur] + 1) {
                arr[cur + 1] = arr[cur] + 1;
                dq.add(cur + 1);
            }
            for (Integer next : map.getOrDefault(cur, new ArrayList<>())) {
                if (arr[next] > arr[cur] + 1) {
                    arr[next] = arr[cur] + 1;
                    dq.add(next);
                }
            }

        }
        sb.append(arr[e]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
