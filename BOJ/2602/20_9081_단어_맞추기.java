import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 9081 단어_맞추기
 * 난이도: SILVER1
 * 유형: 구현
 */
class Main_9081 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/20_9081_단어_맞추기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            char[] arr = br.readLine().toCharArray();
            int arrLastIdx = arr.length - 1;
            char tmp = arr[arrLastIdx];
            boolean isEnded = false;
            loop: for (int i = arrLastIdx - 1; i >= 0; i--) {
                char cur = arr[i];
                if (cur < tmp) {
                    for (int j = arrLastIdx; j > i; j--) {
                        if (arr[j] > cur) {
                            arr[i] = arr[j];
                            arr[j] = cur;
                            Arrays.sort(arr, i + 1, arr.length);
                            sb.append(new String(arr)).append("\n");
                            isEnded = true;
                            break loop;
                        }
                    }
                }
                tmp = cur;
            }
            if (!isEnded)
                sb.append(new String(arr)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
