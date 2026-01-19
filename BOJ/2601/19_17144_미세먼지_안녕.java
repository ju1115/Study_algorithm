import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 17144 미세먼지_안녕
 * 난이도: GOLD4
 * 유형: 구현
 */
class Main_17144 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Dust {
        int r, c, amount;

        Dust(int r, int c, int amount) {
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
    }

    static int R, C, T;
    static int[][] map;
    static int upAirCleaner = -1, downAirCleaner = -1;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/19_17144_미세먼지_안녕.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        boolean foundUp = false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (!foundUp) {
                        upAirCleaner = i;
                        foundUp = true;
                    } else {
                        downAirCleaner = i;
                    }
                }
            }
        }

        while (T-- > 0) {
            spreadDust();
            operateAirPurifier();
        }
        sb.append(calculateTotalDust());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void spreadDust() {
        int[][] tempMap = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0) {
                    int spreadAmount = map[r][c] / 5;
                    int spreadCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
                            tempMap[nr][nc] += spreadAmount;
                            spreadCount++;
                        }
                    }
                    map[r][c] -= (spreadAmount * spreadCount);
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                map[r][c] += tempMap[r][c];
            }
        }
    }

    static void operateAirPurifier() {
        int top = upAirCleaner;
        for (int r = top - 1; r > 0; r--)
            map[r][0] = map[r - 1][0];
        for (int c = 0; c < C - 1; c++)
            map[0][c] = map[0][c + 1];
        for (int r = 0; r < top; r++)
            map[r][C - 1] = map[r + 1][C - 1];
        for (int c = C - 1; c > 1; c--)
            map[top][c] = map[top][c - 1];
        map[top][1] = 0;
        int bottom = downAirCleaner;
        for (int r = bottom + 1; r < R - 1; r++)
            map[r][0] = map[r + 1][0];
        for (int c = 0; c < C - 1; c++)
            map[R - 1][c] = map[R - 1][c + 1];
        for (int r = R - 1; r > bottom; r--)
            map[r][C - 1] = map[r - 1][C - 1];
        for (int c = C - 1; c > 1; c--)
            map[bottom][c] = map[bottom][c - 1];
        map[bottom][1] = 0;
    }

    static int calculateTotalDust() {
        int sum = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0)
                    sum += map[r][c];
            }
        }
        return sum;
    }
}
