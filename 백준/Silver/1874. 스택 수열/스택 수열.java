import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean isWrong = false;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            int su = s[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                int popNum = stack.pop();
                if (popNum != su) {
                    System.out.println("NO");
                    isWrong = true;
                    break;
                }
                else {
                    sb.append("-\n");
                }
            }
        }
        if (!isWrong) {
            System.out.println(sb);
        }
    }
}