import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 14626 ISBN
 * 난이도: BRONZE1
 * 유형: 브루트포스
 */
class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        String input = bf.readLine();
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