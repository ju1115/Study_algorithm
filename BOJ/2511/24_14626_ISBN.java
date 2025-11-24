import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 14626 ISBN
 * 난이도: BRONZE1
 * 유형: 브루트포스
 */
class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/BOJ/2511/24_14626_ISBN.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Code here
        String input = br.readLine();
        char[] cArr = input.toCharArray();
        int ans = 0;
        int num = 0;
        for (int i = 0; i < 12; i++) {
            if (cArr[i] == '*') {
                num = i;
                continue;
            }
            if (i % 2 == 0) {
                ans += cArr[i] - '0';
            } else {
                ans += (cArr[i] - '0') * 3;
            }
        }
        ans += cArr[12] - '0';
        ans = ans % 10;
        ans = (10 - ans) % 10;
        if (num % 2 == 1) {
            ans = check(ans);
        }
        bw.write(ans + "");
        bw.close();
    }

    public static int check(int n) {
        for (int i = 0; i <= 9; i++) {
            if ((i * 3) % 10 == n)
                return i;
        }
        return -1;
    }
}