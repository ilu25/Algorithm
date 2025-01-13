import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 초기화
        Queue<Integer> input = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            input.offer(i);
        }

        // 요세푸스 구하기 (큐)
        int count = 1;
        while (!input.isEmpty()) {
            if (count == K) {
                ans.offer(input.poll());
                count = 0;
            }
            else {
                input.offer(input.poll());
            }
            count++;
        }

        // 요세푸스 출력
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (ans.size() > 1) {
            sb.append(ans.poll()).append(", ");
        }
        sb.append(ans.poll()).append(">");
        System.out.println(sb);
    }
}