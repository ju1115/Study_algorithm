import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 3190 뱀
 * 난이도: GOLD4
 * 유형: 구현
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/22_3190_뱀.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -2;
            }
        }
        arr[0][0] = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a - 1][b - 1] = -1;
        }
        int l = Integer.parseInt(br.readLine());
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            map.put(a, b);
        }
        int direction = 0;
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int hr = 0;
        int hc = 0;
        int tr = 0;
        int tc = 0;
        int time = 0;
        while (true) {
            if (map.get(time) != null) {
                if (map.get(time).equals("D")) {
                    direction = (direction + 1) % 4;
                } else {
                    direction = (direction + 3) % 4;
                }
            }
            hr += dr[direction];
            hc += dc[direction];
            time++;
            if (hr < 0 || hr >= n || hc < 0 || hc >= n || arr[hr][hc] > 0) {
                break;
            }
            if (arr[hr][hc] != -1) {
                arr[hr][hc] = time;
                int tTime = arr[tr][tc];
                arr[tr][tc] = -2;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] == tTime + 1) {
                            tr = i;
                            tc = j;
                            break;
                        }
                    }
                }
            } else {
                arr[hr][hc] = time;
            }
        }
        sb.append(time);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
