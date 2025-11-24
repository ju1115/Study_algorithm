import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 9316 Hello_Judge
 * 난이도: BRONZE5
 * 유형: 구현
 */
class Main_9316 {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2511/24_9316_Hello_Judge.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append("Hello World, Judge ").append(i + 1).append("!").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
