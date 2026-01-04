import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2784 가로_세로_퍼즐
 * 난이도: SILVER2
 * 유형: 구현
 */
class Main_2784 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String[] words = new String[6];
    static String[] result = new String[3];
    static boolean[] visited = new boolean[6];
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/04_2784_가로_세로_퍼즐.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        for (int i = 0; i < 6; i++) {
            String word = br.readLine();
            words[i] = word;
        }
        backtrack(0);
        if (!found) {
            sb.append(0);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void backtrack(int depth) {
        if (found)
            return;

        // 1. 가로줄 3개를 모두 선택했을 때
        if (depth == 3) {
            checkSolution();
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = words[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }

    static void checkSolution() {
        // 2. 가로줄로 만들어진 세로줄 3개를 추출
        List<String> columns = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(result[i].charAt(j));
            }
            columns.add(sb.toString());
        }

        // 3. 사용하지 않은 단어들을 리스트에 담기
        List<String> unused = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (!visited[i]) {
                unused.add(words[i]);
            }
        }

        // 4. 추출한 세로줄 리스트와 남은 단어 리스트를 정렬하여 비교
        Collections.sort(columns);
        // unused는 이미 정렬된 상태의 words에서 가져왔으므로 순서대로임

        if (columns.equals(unused)) {
            for (String row : result) {
                sb.append(row).append("\n");
            }
            found = true;
        }
    }
}
