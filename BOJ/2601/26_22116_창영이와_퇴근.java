import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 22116 창영이와_퇴근
 * 난이도: GOLD4
 * 유형: 그래프
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int x;
        int y;
        int time = 0;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/26_22116_창영이와_퇴근.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        dist[0][0] = 0;
        pq.add(new Node(0, 0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int time = cur.time;
            if (dist[x][y] < time)
                continue;
            if (x == n - 1 && y == n - 1) {
                sb.append(time);
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dr[d];
                int ny = y + dc[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int newTime = Math.max(time, Math.abs(map[nx][ny] - map[x][y]));
                    if (newTime < dist[nx][ny]) {
                        dist[nx][ny] = newTime;
                        pq.add(new Node(nx, ny, newTime));
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
