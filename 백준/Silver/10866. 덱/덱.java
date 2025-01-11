import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front" -> {
                    int x = Integer.parseInt(st.nextToken());
                    deque.addFirst(x);
                }
                case "push_back" -> {
                    int x = Integer.parseInt(st.nextToken());
                    deque.addLast(x);
                }
                case "pop_front" -> {
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(deque.removeFirst());
                    }
                }
                case "pop_back" -> {
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(deque.removeLast());
                    }
                }
                case "size" -> {
                    System.out.println(deque.size());
                }
                case "empty" -> {
                    int isEmpty = deque.isEmpty() ? 1 : 0;
                    System.out.println(isEmpty);
                }
                case "front" -> {
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(deque.getFirst());
                    }
                }
                case "back" -> {
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(deque.getLast());
                    }
                }
            }
        }
    }
}