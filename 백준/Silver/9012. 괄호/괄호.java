import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : input) {
                if (c == '(') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}