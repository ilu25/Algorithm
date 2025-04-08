import java.io.*;
import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[10];
    boolean isEndOfNumber = false;
}

class Trie {
    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public boolean insert(String number) {
        TrieNode node = root;
        boolean isPrefix = false;
        for (char c : number.toCharArray()) {
            int index = c - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            else {
                // 현재 노드가 이미 끝나는 전화번호이면 (이미 접두어 존재)
                if (node.children[index].isEndOfNumber) {
                    isPrefix = true;
                }
            }
            node = node.children[index];
        }
        node.isEndOfNumber = true;

        for (TrieNode child : node.children) {
            // 마지막 노드가 자식을 갖는다면 (현재의 전화번호가 다른 전화번호의 접두어)
            if (child != null) {
                isPrefix = true;
                break;
            }
        }
        return isPrefix;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<String> phoneNumbers = new ArrayList<>();
            Trie trie = new Trie();
            boolean isConsistent = true;

            for (int i = 0; i < n; i++) {
                phoneNumbers.add(br.readLine());
            }

            for (String number : phoneNumbers) {
                if (trie.insert(number)) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}