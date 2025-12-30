import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 14719 빗물
 * 난이도: GOLD5
 * 유형: 구현
 */
class Main_14719 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/30_14719_빗물.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[][] arr = new int[w][h];
        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(st.nextToken());
            for (int j = 0; j < height; j++) {
                arr[i][j] = 1;
            }
        }
        int ans = 0;
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {

                if (arr[i][j] == 1) {
                    int rightWall = -1;
                    for (int k = i + 1; k < w; k++) {
                        if (arr[k][j] == 1) {
                            rightWall = k;
                            break;
                        }
                    }
                    if (rightWall != -1) {
                        for (int k = i + 1; k < rightWall; k++) {
                            if (arr[k][j] == 0) {
                                ans++;
                                arr[k][j] = 1; // 채워진 빗물은 다시 세지 않도록 1로 표시
                            }
                        }
                    }
                }

            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
