import java.util.*;
import java.io.*;

/**
 * 문제: Programmers 468371 노란불_신호등
 * 난이도: Lv_1
 * 유형: 브루트포스
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("Programmers/2604/20_468371_노란불_신호등.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    class Solution {
        class Light {
            int green;
            int yellow;
            int red;

            Light(int green, int yellow, int red) {
                this.green = green;
                this.yellow = yellow;
                this.red = red;
            }
        }

        public int solution(int[][] signals) {
            int signalSize = signals.length;
            Light[] signal = new Light[signalSize];
            int idx = 0;
            for (int[] light : signals) {
                int lightSum = light[0] + light[1] + light[2];
                int green = light[1];
                int red = light[0];
                signal[idx++] = new Light(lightSum, green, red);
            }
            int time = 0;
            int max = 1;
            for (int i = 0; i < signalSize; i++) {
                max *= signal[i].green;
            }
            while (true) {
                time++;
                boolean end = true;
                for (int i = 0; i < signalSize; i++) {
                    int cur = (time - 1) % signal[i].green + 1;
                    cur -= signal[i].red;
                    if (cur < 1) {
                        end = false;
                        break;
                    }
                    cur -= signal[i].yellow;
                    if (cur >= 1) {
                        end = false;
                        break;
                    }
                }
                if (end) {
                    break;
                }
                if (time > max) {
                    time = -1;
                    break;
                }
            }
            return time;
        }
    }
}
