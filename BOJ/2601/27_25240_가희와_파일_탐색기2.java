import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 25240 가희와_파일_탐색기2
 * 난이도: GOLD3
 * 유형: 구현
 */
class Main_25240 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class FileInfo {
        String owner;
        String group;
        char[] info;

        FileInfo(String owner, String group, char[] info) {
            this.owner = owner;
            this.group = group;
            this.info = info;
        }
    }

    static HashMap<String, HashSet<String>> groupUsers;
    static HashSet<Character>[] authoritys;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2601/27_25240_가희와_파일_탐색기2.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        authoritys = new HashSet[8];
        for (int i = 0; i < 8; i++) {
            authoritys[i] = new HashSet<>();
        }
        authoritys[1].add('X');
        authoritys[2].add('W');
        authoritys[3].add('X');
        authoritys[3].add('W');
        authoritys[4].add('R');
        authoritys[5].add('R');
        authoritys[5].add('X');
        authoritys[6].add('W');
        authoritys[6].add('R');
        authoritys[7].add('X');
        authoritys[7].add('W');
        authoritys[7].add('R');

        int U = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        groupUsers = new HashMap<>();
        for (int i = 0; i < U; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (st.hasMoreTokens()) {
                String groups = st.nextToken();
                groups = groups.replace(',', ' ');
                st = new StringTokenizer(groups);
                while (st.hasMoreTokens()) {
                    String group = st.nextToken();
                    groupUsers.putIfAbsent(group, new HashSet<>());
                    groupUsers.get(group).add(name);
                }
            }
            groupUsers.putIfAbsent(name, new HashSet<>());
            groupUsers.get(name).add(name);
        }
        HashMap<String, FileInfo> files = new HashMap<>();
        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            String fileName = st.nextToken();
            char[] info = st.nextToken().toCharArray();
            String owner = st.nextToken();
            String group = st.nextToken();
            files.put(fileName, new FileInfo(owner, group, info));
        }
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String fileName = st.nextToken();
            char operation = st.nextToken().charAt(0);
            FileInfo fileInfo = files.get(fileName);
            operation(name, operation, fileInfo);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void operation(String name, char operation, FileInfo fileInfo) {
        char[] authority = fileInfo.info;

        if (name.equals(fileInfo.owner)) {
            for (int i = 0; i < 2; i++) {
                char cur = authority[i];
                if (authoritys[cur - '0'].contains(operation)) {
                    sb.append("1\n");
                    return;
                }
            }
        } else if (groupUsers.get(fileInfo.group).contains(name)) {

            char cur = authority[1];
            if (authoritys[cur - '0'].contains(operation)) {
                sb.append("1\n");
                return;
            }
        }
        char cur = authority[2];
        if (authoritys[cur - '0'].contains(operation)) {
            sb.append("1\n");
            return;
        }
        sb.append("0\n");
    }
}
