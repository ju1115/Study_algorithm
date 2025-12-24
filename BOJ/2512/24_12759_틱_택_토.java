import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 12759 틱_택_토
 * 난이도: SILVER5
 * 유형: 구현
 */
class Main_12759 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/24_12759_틱_택_토.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int turn = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][4];
        String input;
        boolean draw = true;
        loop: while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = turn;
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
            // check 가로
            for (int i = 1; i < 4; i++) {
                if (arr[i][1] == 0)
                    continue;
                if (arr[i][1] == arr[i][2] && arr[i][2] == arr[i][3]) {
                    sb.append(arr[i][1]);
                    draw = false;
                    break loop;
                }
            }
            // check 세로
            for (int i = 1; i < 4; i++) {
                if (arr[1][i] == 0)
                    continue;
                if (arr[1][i] == arr[2][i] && arr[3][i] == arr[2][i]) {
                    sb.append(arr[1][i]);
                    draw = false;
                    break loop;
                }
            }
            // check 대각선 2개
            if (arr[1][1] != 0 && arr[1][1] == arr[2][2] && arr[2][2] == arr[3][3]) {
                sb.append(arr[1][1]);
                draw = false;
                break loop;
            }
            if (arr[1][3] != 0 && arr[1][3] == arr[2][2] && arr[2][2] == arr[3][1]) {
                sb.append(arr[1][3]);
                draw = false;
                break loop;
            }
        }
        if (draw)
            sb.append(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
