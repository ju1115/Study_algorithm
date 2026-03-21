import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 20336 Haughty_Cuisine
 * 난이도: BRONZE4
 * 유형: 문자열
 */
class Main_20336 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/20_20336_Haughty_Cuisine.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        sb.append(num).append("\n");
        for (int i = 0; i < num; i++) {
            sb.append(st.nextToken()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
