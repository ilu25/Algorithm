import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" -> {
                    stack.push(Integer.parseInt(st.nextToken()));
                }
                case "pop" -> {
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(stack.pop());
                    }
                }
                case "size" -> {
                    System.out.println(stack.size());
                }
                case "empty" -> {
                    int isEmpty = stack.isEmpty() ? 1 : 0;
                    System.out.println(isEmpty);
                }
                case "top" -> {
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(stack.peek());
                    }
                }
            }
        }
    }
}