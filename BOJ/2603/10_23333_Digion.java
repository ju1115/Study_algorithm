import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제: BOJ 23333 Digion
 * 난이도: GOLD1
 * 유형: 문자열
 */
class Main_23333 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String getMin(int weight) {
        return "()".repeat(weight);
    }

    static String getMax(int weight) {
        return "(".repeat(weight) + ")".repeat(weight);
    }

    static boolean isMax(String s, int weight) {
        return s.equals(getMax(weight));
    }

    static int getWeight(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
        }
        return count;
    }

    static String[] parseDigion(String s) {
        if (s == null || s.isEmpty())
            return new String[] { "", "" };

        int depthCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                depthCount++;
            else if (s.charAt(i) == ')')
                depthCount--;

            if (depthCount == 0) {
                String innerNodeA = s.substring(1, i);
                String outerNodeB = s.substring(i + 1);
                return new String[] { innerNodeA, outerNodeB };
            }
        }
        return new String[] { "", "" };
    }

    public static String getNextDigion(String s) {
        int totalWeight = getWeight(s);

        if (isMax(s, totalWeight)) {
            return getMin(totalWeight + 1);
        }

        String[] nodes = parseDigion(s);
        String a = nodes[0];
        String b = nodes[1];

        int weightA = getWeight(a);
        int weightB = getWeight(b);

        if (!isMax(b, weightB)) {
            return "(" + a + ")" + getNextDigion(b);
        }

        if (!isMax(a, weightA)) {
            return "(" + getNextDigion(a) + ")" + getMin(weightB);
        }

        return "(" + getMin(weightA + 1) + ")" + getMin(weightB - 1);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/10_23333_Digion.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String input = br.readLine();

        if (input != null) {
            String cleanInput = input.replace("$", "").trim();
            sb.append(getNextDigion(cleanInput));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
