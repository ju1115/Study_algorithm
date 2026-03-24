import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2638 치즈
 * 난이도: GOLD3
 * 유형: 구현
 */
class Main_2638 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/24_2638_치즈.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int t = 0;
        while (true) {
            int meltCnt = solve();
            if (meltCnt == 0)
                break;
            t++;
        }
        sb.append(t);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int solve() {
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 1)
                    continue;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m || !visited[nx][ny])
                            continue;
                        cnt++;
                    }
                    if (cnt >= 2) {
                        q.add(new Node(i, j));
                    }
                }
            }
        }
        int meltCnt = q.size();
        while (!q.isEmpty()) {
            Node cur = q.poll();
            map[cur.x][cur.y] = 0;
        }
        return meltCnt;
    }
}
