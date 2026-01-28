import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 31575 도시와_비트코인
 * 난이도: SILVER3
 * 유형: 그래프
 */
class Main_31575 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/28_31575_도시와_비트코인.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 0));
        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;
        boolean isEnd = false;
        int[] dr = { 1, 0 };
        int[] dc = { 0, 1 };
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            int x = cur.x;
            int y = cur.y;
            if (x == M - 1 && y == N - 1) {
                isEnd = true;
                break;
            }
            for (int d = 0; d < 2; d++) {
                int nx = x + dr[d];
                int ny = y + dc[d];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        dq.add(new Node(nx, ny));
                    }
                }
            }
        }
        if (isEnd) {
            sb.append("Yes");
        } else {
            sb.append("No");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
