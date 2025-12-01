import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 9237 이장님_초대
 * 난이도: SILVER5
 * 유형: 그리디
 */
class Main_9237 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/01_9237_이장님_초대.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        ArrayList<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr.add(n);
        }
        arr.sort((a, b) -> {
            return b - a;
        });
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i) + 2 + i;
            ans = ans < num ? num : ans;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
