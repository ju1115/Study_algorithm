import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 16923 다음_다양한_단어
 * 난이도: SILVER2
 * 유형: 구현
 */
class Main_16923 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/07_16923_다음_다양한_단어.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String s = br.readLine();
        int n = s.length();
        boolean[] carr = new boolean[26];
        for (char c : s.toCharArray()) {
            carr[c - 'a'] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (!carr[i]) {
                sb.append(s).append((char) ('a' + i));
                break;
            }
        }
        if (sb.toString().isEmpty()) {
            if (s.equals("zyxwvutsrqponmlkjihgfedcba")) {
                sb.append(-1);
            } else {
                // 26자 사전순 다음 단어 찾기
                // 알파벳은 하나씩만 사용됨
                for (int i = n - 1; i >= 0; i--) {
                    char current = s.charAt(i);
                    char nextChar = ' ';
                    for (char c = (char) (current + 1); c <= 'z'; c++) {
                        boolean usedBefore = false;
                        for (int j = 0; j < i; j++) {
                            if (s.charAt(j) == c) {
                                usedBefore = true;
                                break;
                            }
                        }
                        if (!usedBefore) {
                            nextChar = c;
                            break;
                        }
                    }

                    if (nextChar != ' ') {
                        sb.append(s, 0, i).append(nextChar);
                        break;
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
