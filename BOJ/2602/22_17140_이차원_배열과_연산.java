import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 17140 이차원_배열과_연산
 * 난이도: GOLD4
 * 유형: 구현
 */
class Main_17140 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/22_17140_이차원_배열과_연산.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int rowSize = 3;
        int colSize = 3;

        while (time <= 100) {
            if (r < rowSize && c < colSize && arr[r][c] == k) {
                sb.append(time);
                break;
            }

            if (rowSize >= colSize) {
                int maxCol = 0;
                int[][] nextArr = new int[rowSize][100];
                for (int i = 0; i < rowSize; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < colSize; j++) {
                        if (arr[i][j] == 0)
                            continue;
                        map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                    }
                    List<int[]> list = new ArrayList<>();
                    for (int key : map.keySet()) {
                        list.add(new int[] { key, map.get(key) });
                    }
                    list.sort((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
                    int idx = 0;
                    for (int[] pair : list) {
                        if (idx >= 100)
                            break;
                        nextArr[i][idx++] = pair[0];
                        if (idx >= 100)
                            break;
                        nextArr[i][idx++] = pair[1];
                    }
                    maxCol = Math.max(maxCol, idx);
                }
                colSize = maxCol;
                arr = new int[rowSize][colSize];
                for (int i = 0; i < rowSize; i++) {
                    for (int j = 0; j < colSize; j++) {
                        arr[i][j] = nextArr[i][j];
                    }
                }
            } else {
                int maxRow = 0;
                int[][] nextArr = new int[100][colSize];
                for (int i = 0; i < colSize; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < rowSize; j++) {
                        if (arr[j][i] == 0)
                            continue;
                        map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
                    }
                    List<int[]> list = new ArrayList<>();
                    for (int key : map.keySet()) {
                        list.add(new int[] { key, map.get(key) });
                    }
                    list.sort((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
                    int idx = 0;
                    for (int[] pair : list) {
                        if (idx >= 100)
                            break;
                        nextArr[idx++][i] = pair[0];
                        if (idx >= 100)
                            break;
                        nextArr[idx++][i] = pair[1];
                    }
                    maxRow = Math.max(maxRow, idx);
                }
                rowSize = maxRow;
                arr = new int[rowSize][colSize];
                for (int i = 0; i < rowSize; i++) {
                    for (int j = 0; j < colSize; j++) {
                        arr[i][j] = nextArr[i][j];
                    }
                }
            }
            time++;
        }

        if (time > 100) {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
