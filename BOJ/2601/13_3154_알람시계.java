import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 3154 알람시계
 * 난이도: BRONZE1
 * 유형: 구현
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Location {
        int x;
        int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/13_3154_알람시계.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String str = br.readLine();
        Location[] locations = { new Location(1, 3), new Location(0, 0), new Location(1, 0), new Location(2, 0),
                new Location(0, 1), new Location(1, 1), new Location(2, 1), new Location(0, 2), new Location(1, 2),
                new Location(2, 2) };
        int hour = Integer.parseInt(str.substring(0, 2));
        int minute = Integer.parseInt(str.substring(3, 5));
        int ansH = 0;
        int ansM = 0;
        int val = Integer.MAX_VALUE;
        for (int i = hour; i < 100; i += 24) {
            for (int j = minute; j < 100; j += 60) {
                Location first = locations[i / 10];
                Location second = locations[i % 10];
                Location third = locations[j / 10];
                Location fourth = locations[j % 10];
                int dist = Math.abs(first.x - second.x) + Math.abs(first.y - second.y);
                dist += Math.abs(second.x - third.x) + Math.abs(second.y - third.y);
                dist += Math.abs(third.x - fourth.x) + Math.abs(third.y - fourth.y);
                if (val > dist) {
                    val = dist;
                    ansH = i;
                    ansM = j;
                }
            }
        }
        if (ansH < 10)
            sb.append(0);
        sb.append(ansH).append(":");
        if (ansM < 10)
            sb.append(0);
        sb.append(ansM);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
