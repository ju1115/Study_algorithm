import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2313 보석_구매하기
 * 난이도: GOLD5
 * 유형: DP
 */
class Main_2313 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2603/06_2313_보석_구매하기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        long totalMax = 0;
        List<Interval> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long maxVal = -3000000000L;
            int bestStart = -1, bestEnd = -1, bestLen = Integer.MAX_VALUE;

            long currentSum = 0;
            int currentStart = 0;
            for (int j = 0; j < l; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (currentSum <= 0) {
                    currentSum = value;
                    currentStart = j;
                } else {
                    currentSum += value;
                }
                int currentLen = j - currentStart + 1;

                if (currentSum > maxVal) {
                    maxVal = currentSum;
                    bestStart = currentStart;
                    bestEnd = j;
                    bestLen = currentLen;
                } else if (currentSum == maxVal) {
                    if (currentLen < bestLen) {
                        bestStart = currentStart;
                        bestEnd = j;
                        bestLen = currentLen;
                    }
                }
            }

            totalMax += maxVal;
            results.add(new Interval(bestStart + 1, bestEnd + 1));
        }
        sb.append(totalMax).append("\n");
        for (Interval res : results) {
            sb.append(res.start).append(" ").append(res.end).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
