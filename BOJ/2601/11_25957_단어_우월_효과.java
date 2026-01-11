import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25957 단어_우월_효과
 * 난이도: SILVER2
 * 유형: 문자열
 */
class Main_25957 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/11_25957_단어_우월_효과.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        char[] buffer = new char[8];
        HashMap<Integer, HashMap<String, HashMap<String, String>>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int len = str.length();
            StringBuilder sb = new StringBuilder(2);
            sb.append(str.charAt(0));
            sb.append(str.charAt(len - 1));
            String se = sb.toString();
            str.getChars(0, len, buffer, 0);
            Arrays.sort(buffer, 0, len);
            map.putIfAbsent(len, new HashMap<>());
            map.get(len).putIfAbsent(se, new HashMap<>());
            map.get(len).get(se).put(new String(buffer, 0, len), str);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {

            String str = st.nextToken();
            int len = str.length();
            StringBuilder sb2 = new StringBuilder(2);
            sb2.append(str.charAt(0));
            sb2.append(str.charAt(len - 1));
            String se = sb2.toString();
            str.getChars(0, len, buffer, 0);
            Arrays.sort(buffer, 0, len);
            sb.append(map.get(len).get(se).get(new String(buffer, 0, len))).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
