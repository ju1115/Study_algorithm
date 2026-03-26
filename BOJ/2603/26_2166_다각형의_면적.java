import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 2166 다각형의_면적
 * 난이도: GOLD5
 * 유형: 수학
 */
class Main_2166 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/26_2166_다각형의_면적.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            points.add(new Point(x1, y1));
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);

            sum += (p1.x * p2.y) - (p2.x * p1.y);
        }
        sb.append(String.format("%.1f", Math.abs(sum) / 2.0));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
