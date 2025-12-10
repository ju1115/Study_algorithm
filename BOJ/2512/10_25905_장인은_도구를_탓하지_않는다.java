import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25905 장인은_도구를_탓하지_않는다
 * 난이도: BRONZE2
 * 유형: 구현
 */
class Main_25905 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/10_25905_장인은_도구를_탓하지_않는다.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        double ans = 1.0;
        ArrayList<Double> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(Double.parseDouble(br.readLine()));
        }
        Collections.sort(arr);
        for (int i = 1; i < 10; i++) {
            ans *= arr.get(i) / i;
        }
        sb.append(ans *= 1000000000);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
