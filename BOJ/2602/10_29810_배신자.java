import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 29810 배신자
 * 난이도: GOLD3
 * 유형: 그래프
 */
class Main_29810 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/10_29810_배신자.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        int x = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        visited[x] = true;
        int ans = 0;
        for (int num : arr[x]) {
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            dq.add(num);
            visited[num] = true;
            int size = 1;
            boolean cycle = false;
            while (!dq.isEmpty()) {
                int cur = dq.pollFirst();
                for (int next : arr[cur]) {
                    if (next == x && cur != num)
                        cycle = true;
                    if (!visited[next]) {
                        visited[next] = true;
                        dq.add(next);
                        size++;
                    }
                }
            }
            if (!cycle)
                size++;
            ans = Math.max(ans, size);
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                ArrayDeque<Integer> dq = new ArrayDeque<>();
                dq.add(i);
                visited[i] = true;
                int size = 1;
                while (!dq.isEmpty()) {
                    int cur = dq.pollFirst();
                    for (int next : arr[cur]) {
                        if (!visited[next]) {
                            visited[next] = true;
                            dq.add(next);
                            size++;
                        }
                    }
                }
                ans = Math.max(ans, size);
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
