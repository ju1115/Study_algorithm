import java.util.*;
import java.io.*;

/**
 * 문제: Programmers 388351 유연근무제
 * 난이도: Lv_1
 * 유형: 구현
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("Programmers/2604/27_388351_유연근무제.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    class Solution {
        class Schedule {
            int hopeS, hopeE, startday;
            int[] timelogs;

            Schedule(int hopeS, int startday, int[] timelogs) {
                this.hopeS = hopeS;
                this.startday = startday - 1;
                this.timelogs = timelogs;
                int hopeEm = ((hopeS % 100) + 10);
                int hopeEh = hopeS - hopeS % 100;
                this.hopeE = hopeEh + (hopeEm / 60) * 100 + hopeEm % 60;
            }

            boolean calculate() {
                for (int i = 0; i < 7; i++) {
                    startday %= 7;
                    if (startday != 5 && startday != 6) {
                        if (!check(i)) {
                            return false;
                        }
                    }
                    startday++;
                }
                return true;
            }

            boolean check(int i) {
                if (timelogs[i] > hopeE)
                    return false;
                return true;
            }
        }

        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;
            ArrayList<Schedule> scheduleArr = new ArrayList<>();
            for (int i = 0; i < schedules.length; i++) {
                scheduleArr.add(new Schedule(schedules[i], startday, timelogs[i]));
            }
            for (Schedule schedule : scheduleArr) {
                if (schedule.calculate()) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
