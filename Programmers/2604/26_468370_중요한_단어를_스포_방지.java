import java.util.*;
import java.io.*;

/**
 * 문제: Programmers 468370 중요한_단어를_스포_방지
 * 난이도: Lv_1
 * 유형: 문자열
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("Programmers/2604/26_468370_중요한_단어를_스포_방지.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    class Solution {
        public class Message {
            int start, end;
            String content;

            Message(int start, int end, String content) {
                this.start = start;
                this.end = end;
                this.content = content;
            }
        }

        public int solution(String message, int[][] spoiler_ranges) {
            int answer = 0;
            char[] cArr = message.toCharArray();
            ArrayList<Message> messages = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int start = 0;
            for (int i = 0; i < cArr.length; i++) {
                char cur = cArr[i];
                if (cur == ' ') {
                    start = i + 1;
                    continue;
                }
                sb.append(cur);
                if (i == cArr.length - 1 || cArr[i + 1] == ' ') {
                    messages.add(new Message(start, i, sb.toString()));
                    sb = new StringBuilder();
                }
            }
            HashSet<String> notImportants = new HashSet<>();
            ArrayList<String> spoilers = new ArrayList<>();
            int idx = 0;
            for (Message m : messages) {
                while (true) {
                    if (idx == spoiler_ranges.length) {
                        notImportants.add(m.content);
                        break;
                    }
                    int ss = spoiler_ranges[idx][0];
                    int se = spoiler_ranges[idx][1];
                    if (se < m.start) {
                        idx++;
                        continue;
                    }
                    if (ss > m.end) {
                        notImportants.add(m.content);
                        break;
                    }
                    spoilers.add(m.content);
                    break;
                }
            }
            for (String s : spoilers) {
                if (!notImportants.contains(s)) {
                    answer++;
                    notImportants.add(s);
                }
            }
            return answer;
        }
    }

}
