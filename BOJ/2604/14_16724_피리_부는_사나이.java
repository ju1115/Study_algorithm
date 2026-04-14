import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 16724 피리_부는_사나이
 * 난이도: GOLD3
 * 유형: 구현
 */
class Main_16724 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2604/14_16724_피리_부는_사나이.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        int[][] visitedRank = new int[n][m];
        int rank = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j])
                    continue;
                visited[i][j] = true;
                visitedRank[i][j] = rank;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] { i, j });
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int[] dir = next(arr[cur[0]][cur[1]]);
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if (visited[nx][ny]) {
                        if (visitedRank[nx][ny] == rank) {
                            ans++;
                        }
                        break;
                    }
                    visited[nx][ny] = true;
                    visitedRank[nx][ny] = rank;
                    q.add(new int[] { nx, ny });
                }
                rank++;
            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int[] next(char c) {
        switch (c) {
            case 'U':
                return new int[] { -1, 0 };
            case 'D':
                return new int[] { 1, 0 };
            case 'L':
                return new int[] { 0, -1 };
            case 'R':
                return new int[] { 0, 1 };
        }
        return null;
    }
}
