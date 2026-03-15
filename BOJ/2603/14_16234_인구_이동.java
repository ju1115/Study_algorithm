import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 16234 인구_이동
 * 난이도: GOLD4
 * 유형: 구현
 */
class Main_16234 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/14_16234_인구_이동.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        int time = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        while (true) {
            boolean isMoved = false;
            boolean[][] visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        ArrayDeque<int[]> queue = new ArrayDeque<>();
                        List<int[]> union = new ArrayList<>();
                        visited[i][j] = true;
                        queue.add(new int[] { i, j });
                        union.add(new int[] { i, j });
                        int sum = arr[i][j];
                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            int x = cur[0];
                            int y = cur[1];

                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];

                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                                    int diff = Math.abs(arr[x][y] - arr[nx][ny]);
                                    if (diff >= l && diff <= r) {
                                        visited[nx][ny] = true;
                                        queue.add(new int[] { nx, ny });
                                        union.add(new int[] { nx, ny });
                                        sum += arr[nx][ny];
                                    }
                                }
                            }
                        }
                        if (union.size() > 1) {
                            isMoved = true;
                            int avg = sum / union.size();
                            for (int[] pos : union) {
                                arr[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }
            if (!isMoved)
                break;
            time++;
        }
        sb.append(time);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
