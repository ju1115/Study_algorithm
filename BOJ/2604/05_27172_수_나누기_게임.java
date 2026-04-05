import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 27172 수_나누기_게임
 * 난이도: GOLD4
 * 유형: 수학
 */
class Main_27172 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2604/05_27172_수_나누기_게임.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> score = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            set.add(num);
            score.put(num, 0);
        }
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            for (int j = num * 2; j < 1000001; j += num) {
                if (set.contains(j)) {
                    score.put(j, score.get(j) - 1);
                    score.put(num, score.get(num) + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(score.get(arr[i])).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
