import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 30701 돌아온_똥게임
 * 난이도: SILVER3
 * 유형: 그리디
 */
class Main_30701 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/25_30701_돌아온_똥게임.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        ArrayList<Long> monsters = new ArrayList<>();
        ArrayList<Long> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            if (a == 1) {
                monsters.add(x);
            } else {
                items.add(x);
            }
        }
        Collections.sort(monsters);
        Collections.sort(items);
        int ans = items.size();
        int monsterIdx = 0;
        int itemIdx = 0;
        while (true) {
            if (monsterIdx == monsters.size())
                break;
            long monsterScore = monsters.get(monsterIdx);
            if (d <= monsterScore) {
                if (itemIdx == items.size())
                    break;
                long itemScore = items.get(itemIdx);
                d *= itemScore;
                itemIdx++;
            } else {
                ans++;
                monsterIdx++;
                d += monsterScore;

            }
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
