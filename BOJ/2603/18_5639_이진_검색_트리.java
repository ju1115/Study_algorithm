import java.util.*;
import java.io.*;

/**
 * 문제: BOJ 5639 이진_검색_트리
 * 난이도: GOLD4
 * 유형: 그래프
 */
class Main_5639 {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        Node left, right;
        int val;

        Node(int val) {
            this.val = val;
        }

        void insert(int n) {
            if (n < this.val) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("BOJ/2603/18_5639_이진_검색_트리.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Code here
        String input = br.readLine();
        Node root = new Node(Integer.parseInt(input));
        while ((input = br.readLine()) != null) {
            int val = Integer.parseInt(input);
            root.insert(val);
        }
        postOrder(root);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.val).append("\n");
    }
}
