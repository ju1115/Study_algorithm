import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 6676 Inglish-Number_Translator
 * 난이도: SILVER1
 * 유형: 문자열
 */
class Main_6676 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new
        // FileInputStream("BOJ/2603/23_6676_Inglish-Number_Translator.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("million", 1000000);

        String input;
        while ((input = br.readLine()) != null) {
            if (input.isEmpty())
                break;
            st = new StringTokenizer(input);
            int num = 0;
            int add = 0;
            boolean isNegative = false;
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (token.equals("negative")) {
                    isNegative = true;
                    continue;
                }
                int val = map.get(token);
                if (val == 100) {
                    add *= 100;
                } else if (val >= 1000) {
                    add *= val;
                    num += add;
                    add = 0;
                } else {
                    add += val;
                }
            }
            int ans = num + add;
            if (isNegative) {
                ans *= -1;
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
