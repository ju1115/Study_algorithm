import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 20916 안녕_2020_안녕_2021
 * 난이도: GOLD5
 * 유형: 자료구조
 */
class Main_20916 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static final long[] TARGETS = {
            202021L,
            20202021L,
            202002021L, 202012021L, 202022021L, 202032021L, 202042021L,
            202052021L, 202062021L, 202072021L, 202082021L, 202092021L
    };

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("BOJ/2602/14_20916_안녕_2020_안녕_2021.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            long count = 0;
            for (int i = 0; i < n; i++) {
                int current = arr[i];
                if (map.get(current) == 1) {
                    map.remove(current);
                } else {
                    map.put(current, map.get(current) - 1);
                }
                for (long target : TARGETS) {
                    long neededLong = target - current;
                    if (neededLong < -300_000_000 || neededLong > 300_000_000)
                        continue;

                    int needed = (int) neededLong;

                    if (map.containsKey(needed)) {
                        count += map.get(needed);
                    }
                }
            }
            sb.append(count).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
