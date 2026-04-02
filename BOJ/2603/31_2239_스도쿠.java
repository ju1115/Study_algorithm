import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2239 스도쿠
 * 난이도: GOLD4
 * 유형: 구현
 */
class Main_2239 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] map = new int[9][9];
    static List<int[]> emptyCells = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/31_2239_스도쿠.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            if (line == null)
                break;
            for (int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
                if (map[i][j] == 0) {
                    emptyCells.add(new int[] { i, j });
                }
            }
        }
        solve(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean solve(int index) {
        if (index == emptyCells.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            return true;
        }

        int[] curr = emptyCells.get(index);
        int r = curr[0];
        int c = curr[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(r, c, num)) {
                map[r][c] = num;

                if (solve(index + 1))
                    return true;

                map[r][c] = 0;
            }
        }

        return false;
    }

    private static boolean isValid(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == num || map[i][c] == num)
                return false;
        }

        int startR = (r / 3) * 3;
        int startC = (c / 3) * 3;
        for (int i = startR; i < startR + 3; i++) {
            for (int j = startC; j < startC + 3; j++) {
                if (map[i][j] == num)
                    return false;
            }
        }
        return true;
    }

}
