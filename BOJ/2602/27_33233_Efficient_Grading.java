import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 33233 Efficient_Grading
 * 난이도: SILVER1
 * 유형: 수학, 브루트포스, 그리디
 */
class Main_33233 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/27_33233_Efficient_Grading.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()); // 시험지 수
        long t = Long.parseLong(st.nextToken()); // 단위 시간

        solve(n, t);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void solve(long n, long t) {
        long minSlots = Long.MAX_VALUE;

        for (int k = 0; k <= 22; k++) {
            long graders = 1L << k;

            long gradingRounds = (n + graders - 1) / graders;
            long totalSlots = k + gradingRounds;

            if (totalSlots < minSlots) {
                minSlots = totalSlots;
            } else {
                break;
            }
        }

        long minTime = minSlots * t;
        long minGraders = Long.MAX_VALUE;

        for (int i = 0; i < minSlots; i++) {
            long remSlots = minSlots - i;
            long baseGraders = 1L << i;

            long workBase = baseGraders * remSlots;

            long currentGraders;

            if (workBase >= n) {
                currentGraders = baseGraders;
            } else {

                if (remSlots <= 2) {
                    continue;
                }

                long needed = n - workBase;
                long gainPerPerson = remSlots - 2;
                long x = (needed + gainPerPerson - 1) / gainPerPerson;
                if (x <= baseGraders) {
                    currentGraders = baseGraders + x;
                } else {
                    continue;
                }
            }

            if (currentGraders < minGraders) {
                minGraders = currentGraders;
            }
        }

        sb.append(minTime).append(" ").append(minGraders);
    }
}