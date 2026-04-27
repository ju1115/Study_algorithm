import java.util.*;
import java.io.*;

/**
 * 문제: Programmers 340213 동영상_재생기
 * 난이도: Lv_1
 * 유형: 구현
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("Programmers/2604/27_340213_동영상_재생기.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    class Solution {
        class Video {
            int cur; // 현재 재생 위치 (초)
            int videoLen; // 전체 비디오 길이 (초)
            int opStart; // 오프닝 시작 (초)
            int opEnd; // 오프닝 종료 (초)
            String[] commands;

            Video(String cur, String videoLen, String opStart, String opEnd, String[] commands) {
                this.cur = convertToSeconds(cur);
                this.videoLen = convertToSeconds(videoLen);
                this.opStart = convertToSeconds(opStart);
                this.opEnd = convertToSeconds(opEnd);
                this.commands = commands;
            }

            // mm:ss 포맷을 초 단위 정수로 변환
            int convertToSeconds(String input) {
                String[] split = input.split(":");
                return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            }

            // 초 단위 정수를 mm:ss 포맷으로 변환
            String formatTime(int totalSeconds) {
                int m = totalSeconds / 60;
                int s = totalSeconds % 60;
                return String.format("%02d:%02d", m, s);
            }

            void checkOpening() {
                if (cur >= opStart && cur <= opEnd) {
                    cur = opEnd;
                }
            }

            String solve() {
                // 시작 시점에 오프닝 구간인지 먼저 확인
                checkOpening();

                for (String cmd : commands) {
                    if (cmd.equals("next")) {
                        cur = Math.min(videoLen, cur + 10);
                    } else if (cmd.equals("prev")) {
                        cur = Math.max(0, cur - 10);
                    }
                    // 각 명령 수행 후 오프닝 구간인지 다시 확인
                    checkOpening();
                }
                return formatTime(cur);
            }
        }

        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            Video video = new Video(pos, video_len, op_start, op_end, commands);
            return video.solve();
        }
    }
}
