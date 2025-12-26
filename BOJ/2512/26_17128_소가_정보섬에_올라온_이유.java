import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 17128 소가_정보섬에_올라온_이유
 * 난이도: SILVER2
 * 유형: 구현
 */
class Main_17128 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/26_17128_소가_정보섬에_올라온_이유.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sArr = new int[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            sArr[i] = arr[i % n] * arr[(i + 1) % n] * arr[(i + 2) % n] * arr[(i + 3) % n];
            ans += sArr[i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int cow = Integer.parseInt(st.nextToken()) - 1;
            for (int j = 0; j < 4; j++) {
                int targetIdx = (cow - j + n) % n;
                ans -= 2 * sArr[targetIdx];
                sArr[targetIdx] = -sArr[targetIdx];
            }
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
