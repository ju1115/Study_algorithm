import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 13945 Appearance_Analysis
 * 난이도: SILVER1
 * 유형: 구현
 */
class Main_13945 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2603/12_13945_Appearance_Analysis.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] carr = new char[r][c];
        for (int i = 0; i < r; i++) {
            carr[i] = br.readLine().toCharArray();
        }
        int rSize = 0;
        for (int i = 1; i < r; i++) {
            if (carr[i][1] == '#')
                break;
            rSize++;
        }
        int cSize = 0;
        for (int i = 1; i < c; i++) {
            if (carr[1][i] == '#')
                break;
            cSize++;
        }
        Set<String> set = new HashSet<>();
        for (int i = 1; i < r; i += rSize + 1) {
            for (int j = 1; j < c; j += cSize + 1) {
                char[][] window = new char[rSize][cSize];

                for (int x = 0; x < rSize; x++) {
                    for (int y = 0; y < cSize; y++) {
                        window[x][y] = carr[i + x][j + y];
                    }
                }

                String canonicalForm = getCanonicalString(window, rSize, cSize);
                set.add(canonicalForm);
            }
        }
        sb.append(set.size());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static String getCanonicalString(char[][] window, int rSize, int cSize) {
        List<String> rotations = new ArrayList<>();

        rotations.add(arrToString(window, rSize, cSize));

        char[][] rot180 = new char[rSize][cSize];
        for (int x = 0; x < rSize; x++) {
            for (int y = 0; y < cSize; y++) {
                rot180[x][y] = window[rSize - 1 - x][cSize - 1 - y];
            }
        }
        rotations.add(arrToString(rot180, rSize, cSize));

        if (rSize == cSize) {
            char[][] rot90 = new char[rSize][cSize];
            char[][] rot270 = new char[rSize][cSize];
            for (int x = 0; x < rSize; x++) {
                for (int y = 0; y < cSize; y++) {
                    rot90[y][rSize - 1 - x] = window[x][y];
                    rot270[rSize - 1 - y][x] = window[x][y];
                }
            }
            rotations.add(arrToString(rot90, rSize, cSize));
            rotations.add(arrToString(rot270, rSize, cSize));
        }

        return rotations.stream().min(String::compareTo).get();
    }

    static String arrToString(char[][] arr, int r, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
