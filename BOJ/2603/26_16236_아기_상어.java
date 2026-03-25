import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 16236 아기_상어
 * 난이도: GOLD3
 * 유형: 구현
 */
class Main_16236 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static class Shark {
        int x, y;
        int time;
        int n;
        int size;
        int eat;
        int[][] map;

        Shark(int n) {
            this.x = 0;
            this.y = 0;
            this.time = 0;
            this.n = n;
            this.map = new int[n][n];
            this.size = 2;
        }

        boolean find() {
            boolean[][] visited = new boolean[n][n];
            Queue<Node> q = new ArrayDeque<>();
            Queue<Node> pq = new PriorityQueue<>((a, b) -> {
                if (a.dist != b.dist) {
                    return a.dist - b.dist;
                } else if (a.x != b.x) {
                    return a.x - b.x;
                } else {
                    return a.y - b.y;
                }
            });
            q.add(new Node(x, y, 0));
            visited[x][y] = true;
            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || map[nx][ny] > size)
                        continue;
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0 || map[nx][ny] == size)
                        q.add(new Node(nx, ny, cur.dist + 1));
                    else {
                        pq.add(new Node(nx, ny, cur.dist + 1));
                    }
                }
            }
            if (!pq.isEmpty()) {
                Node next = pq.poll();
                x = next.x;
                y = next.y;
                time += next.dist;
                return true;
            }
            return false;
        }

        void eat() {
            if (map[x][y] < size) {
                map[x][y] = 0;
                eat++;
            }
            if (eat == size) {
                size++;
                eat = 0;
            }
        }
    }

    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/26_16236_아기_상어.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        Shark shark = new Shark(n);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                shark.map[i][j] = Integer.parseInt(st.nextToken());
                if (shark.map[i][j] == 9) {
                    shark.x = i;
                    shark.y = j;
                    shark.map[i][j] = 0;
                }
            }
        }
        while (shark.find()) {
            shark.eat();
        }
        sb.append(shark.time);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
