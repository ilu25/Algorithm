import java.io.*;
import java.util.*;

class Node {
    private char c1;
    private char c2;

    public Node(char c1, char c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public char getC1() {
        return c1;
    }
    public char getC2() {
        return c2;
    }
}

class Main {
    static Node[] tree;
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new Node[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char child1 = st.nextToken().charAt(0);
            char child2 = st.nextToken().charAt(0);

            int pIdx = parent - 'A';
            tree[pIdx] = new Node(child1, child2);
        }

        sb = new StringBuilder();
        // 전위 순회
        preOrder('A');
        sb.append('\n');

        // 중위 순회
        midOrder('A');
        sb.append('\n');

        // 후위 순회
        aftOrder('A');
        System.out.print(sb);
    }

    static void preOrder(char p) {
        sb.append(p);
        if (tree[p - 'A'].getC1() != '.') {
            preOrder(tree[p - 'A'].getC1());
        }
        if (tree[p - 'A'].getC2() != '.') {
            preOrder(tree[p - 'A'].getC2());
        }
    }

    static void midOrder(char p) {
        if (tree[p - 'A'].getC1() != '.') {
            midOrder(tree[p - 'A'].getC1());
        }
        sb.append(p);
        if (tree[p - 'A'].getC2() != '.') {
            midOrder(tree[p - 'A'].getC2());
        }
    }

    static void aftOrder(char p) {
        if (tree[p - 'A'].getC1() != '.') {
            aftOrder(tree[p - 'A'].getC1());
        }
        if (tree[p - 'A'].getC2() != '.') {
            aftOrder(tree[p - 'A'].getC2());
        }
        sb.append(p);
    }

}