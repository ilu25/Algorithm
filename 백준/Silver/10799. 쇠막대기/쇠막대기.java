import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 11:09 ~ 11:51
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int ans = 0;
        int numberOfRemainingSticks = 0;
        for (char c : input) {
            if (c == '(') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    numberOfRemainingSticks++;
                }
            }
            else if (c == ')') {
                if (stack.peek() == ')') {
                    numberOfRemainingSticks--;
                    ans++;
                }
                else {
                    ans += numberOfRemainingSticks;
                }
            }
            stack.push(c);
        }
        System.out.println(ans);
    }
}