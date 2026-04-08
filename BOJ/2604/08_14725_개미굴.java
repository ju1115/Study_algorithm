import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 14725 개미굴
 * 난이도: GOLD3
 * 유형: 문자열
 */
class Main_14725 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Room {
        String name;
        Set<String> next;
        int rank;
        Map<String, Room> child;

        Room(String name, int rank) {
            this.name = name;
            next = new HashSet<>();
            child = new TreeMap<>();
            this.rank = rank;
        }

        boolean isHave(String name) {
            return next.contains(name);
        }

        void add(String name) {
            next.add(name);
        }

        Room getChildRoom(String name) {
            return child.get(name);
        }

        void addChild(String name) {
            child.put(name, new Room(name, rank + 1));
        }

        void print() {
            for (int i = 0; i < rank; i++) {
                sb.append("--");
            }
            if (!name.equals("root"))
                sb.append(name).append("\n");
            for (String s : child.keySet()) {
                child.get(s).print();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2604/08_14725_개미굴.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        int n = Integer.parseInt(br.readLine());
        Room root = new Room("root", -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Room cur = root;
            for (int j = 0; j < k; j++) {
                String s = st.nextToken();
                if (!cur.isHave(s)) {
                    cur.add(s);
                    cur.addChild(s);
                }
                cur = cur.getChildRoom(s);
            }
        }
        root.print();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
