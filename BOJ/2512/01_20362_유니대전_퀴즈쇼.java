import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 20362 유니대전_퀴즈쇼
 * 난이도: BRONZE1
 * 유형: 문자열
 */
class Main_20362 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2512/01_20362_유니대전_퀴즈쇼.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String S = st.nextToken();
        ArrayList<String> arr = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        String ans = "";
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String user = st.nextToken();
            String text = st.nextToken();
            arr.add(user);
            map.put(user, text);
            if (user.equals(S))
                ans = text;
        }
        int answer = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(S)) {
                break;
            }
            if (map.get(arr.get(i)).equals(ans))
                answer++;
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
