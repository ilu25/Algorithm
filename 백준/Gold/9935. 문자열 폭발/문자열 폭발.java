import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= bomb.length()) {
                boolean match = true;
                for (int j = 0; j < bomb.length(); j++) {
                	int idx = stack.size() - bomb.length() + j;
                    if (stack.get(idx) != bomb.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("FRULA");
        } 
        else {
            for (char c : stack) {
                sb.append(c);
            }
        }
        System.out.print(sb);
    }
}