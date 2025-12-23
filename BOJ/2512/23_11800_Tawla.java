import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 11800 Tawla
 * 난이도: BRONZE3
 * 유형: 구현
 */
class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/23_11800_Tawla.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append("Case ").append(i).append(": ");
            String[][] arr = new String[7][7];
            arr[1][1] = "Habb Yakk";
            arr[2][2] = "Dobara";
            arr[3][3] = "Dousa";
            arr[4][4] = "Dorgy";
            arr[5][5] = "Dabash";
            arr[6][6] = "Dosh";
            String[] dice = new String[7];
            dice[1] = "Yakk";
            dice[2] = "Doh";
            dice[3] = "Seh";
            dice[4] = "Ghar";
            dice[5] = "Bang";
            dice[6] = "Sheesh";

            int max = Math.max(a, b);
            int min = Math.min(a, b);
            if (max == 6 && min == 5) {
                sb.append("Sheesh Beesh");
            } else if (max == min) {
                sb.append(arr[max][min]);
            } else {
                sb.append(dice[max]).append(" ").append(dice[min]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
