import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 4435 중간계_전쟁
 * 난이도: BRONZE3
 * 유형: 구현
 */
class Main_4435 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/20_4435_중간계_전쟁.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            int gandalfSum = 0;
            gandalfSum += Integer.parseInt(st.nextToken()); // hobbit
            gandalfSum += Integer.parseInt(st.nextToken()) * 2; // human
            gandalfSum += Integer.parseInt(st.nextToken()) * 3; // elf
            gandalfSum += Integer.parseInt(st.nextToken()) * 3; // dwarf
            gandalfSum += Integer.parseInt(st.nextToken()) * 4; // eagle
            gandalfSum += Integer.parseInt(st.nextToken()) * 10; // wizard

            st = new StringTokenizer(br.readLine());
            int sauronSum = 0;
            sauronSum += Integer.parseInt(st.nextToken()); // orc
            sauronSum += Integer.parseInt(st.nextToken()) * 2; // human
            sauronSum += Integer.parseInt(st.nextToken()) * 2; // warg
            sauronSum += Integer.parseInt(st.nextToken()) * 2; // goblin
            sauronSum += Integer.parseInt(st.nextToken()) * 3; // uruk-hai
            sauronSum += Integer.parseInt(st.nextToken()) * 5; // troll
            sauronSum += Integer.parseInt(st.nextToken()) * 10; // wizard

            sb.append("Battle ").append(i).append(": ");
            if (gandalfSum > sauronSum) {
                sb.append("Good triumphs over Evil\n");
            } else if (gandalfSum < sauronSum) {
                sb.append("Evil eradicates all trace of Good\n");
            } else {
                sb.append("No victor on this battle field\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
