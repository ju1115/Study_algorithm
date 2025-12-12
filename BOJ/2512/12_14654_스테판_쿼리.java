import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 14654 스테판_쿼리
 * 난이도: SILVER4
 * 유형: 구현
 */
class Main_14654 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/12_14654_스테판_쿼리.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] teamA = new int[n];
        for (int i = 0; i < n; i++) {
            teamA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] teamB = new int[n];
        for (int i = 0; i < n; i++) {
            teamB[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int win = 0;
        // false A true B
        boolean winner = false;
        for (int i = 0; i < n; i++) {
            int a = teamA[i];
            int b = teamB[i];
            if (a == b) {
                winner = !winner;
                win = 1;
                continue;
            }
            if (a == 1) {
                if (b == 2) {
                    if (!winner) {
                        win = 0;
                    }
                    winner = true;
                    win++;
                } else {
                    if (winner) {
                        win = 0;
                    }
                    winner = false;
                    win++;
                }
            } else if (a == 2) {
                if (b == 3) {
                    if (!winner) {
                        win = 0;
                    }
                    winner = true;
                    win++;
                } else {
                    if (winner) {
                        win = 0;
                    }
                    winner = false;
                    win++;
                }
            } else {
                if (b == 1) {
                    if (!winner) {
                        win = 0;
                    }
                    winner = true;
                    win++;
                } else {
                    if (winner) {
                        win = 0;
                    }
                    winner = false;
                    win++;
                }
            }
            ans = Math.max(ans, win);
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
