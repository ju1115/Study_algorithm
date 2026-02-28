import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 21750 Два_коня
 * 난이도: GOLD5
 * 유형: 구현
 */
class Main_21750 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Path {
        Path parent;
        String parentPath;

        Path(Path parent, String parentPath) {
            this.parent = parent;
            this.parentPath = parentPath;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2602/28_21750_Два_коня.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        st = new StringTokenizer(br.readLine());
        String wStart = st.nextToken();
        String bStart = st.nextToken();
        String wEnd = st.nextToken();
        String bEnd = st.nextToken();
        int wc = wStart.charAt(0) - 'a';
        int wr = wStart.charAt(1) - '1';
        int bc = bStart.charAt(0) - 'a';
        int br = bStart.charAt(1) - '1';
        int wec = wEnd.charAt(0) - 'a';
        int wer = wEnd.charAt(1) - '1';
        int bec = bEnd.charAt(0) - 'a';
        int ber = bEnd.charAt(1) - '1';
        boolean[][][][] visited = new boolean[8][8][8][8];
        Path[][][][] path = new Path[8][8][8][8];
        int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] dr = { 1, 2, 2, 1, -1, -2, -2, -1 };
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { wc, wr, bc, br });
        visited[wc][wr][bc][br] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cwc = cur[0], cwr = cur[1], cbc = cur[2], cbr = cur[3];

            if (cwc == wec && cwr == wer && cbc == bec && cbr == ber) {
                List<String> result = new ArrayList<>();
                Path p = path[cwc][cwr][cbc][cbr];
                while (p != null) {
                    result.add(p.parentPath);
                    p = p.parent;
                }
                Collections.reverse(result);
                sb.append(result.size()).append("\n");
                for (String s : result) {
                    sb.append(s).append("\n");
                }
                found = true;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nwc = cwc + dc[i];
                int nwr = cwr + dr[i];
                if (nwc < 0 || nwc >= 8 || nwr < 0 || nwr >= 8)
                    continue;
                if (nwc == cbc && nwr == cbr)
                    continue;
                if (!visited[nwc][nwr][cbc][cbr]) {
                    visited[nwc][nwr][cbc][cbr] = true;
                    path[nwc][nwr][cbc][cbr] = new Path(path[cwc][cwr][cbc][cbr],
                            'W' + " " + (char) (nwc + 'a') + (nwr + 1));
                    q.add(new int[] { nwc, nwr, cbc, cbr });
                }
            }

            for (int j = 0; j < 8; j++) {
                int nbc = cbc + dc[j];
                int nbr = cbr + dr[j];
                if (nbc < 0 || nbc >= 8 || nbr < 0 || nbr >= 8)
                    continue;
                if (nbc == cwc && nbr == cwr)
                    continue;
                if (!visited[cwc][cwr][nbc][nbr]) {
                    visited[cwc][cwr][nbc][nbr] = true;
                    path[cwc][cwr][nbc][nbr] = new Path(path[cwc][cwr][cbc][cbr],
                            'B' + " " + (char) (nbc + 'a') + (nbr + 1));
                    q.add(new int[] { cwc, cwr, nbc, nbr });
                }
            }
        }
        if (!found) {
            sb.append("-1\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
