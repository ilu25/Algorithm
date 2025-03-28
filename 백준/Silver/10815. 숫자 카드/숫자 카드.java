import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Long> cards = new HashSet<>();
        for (int i = 0; i < N; i++) {
            cards.add(Long.parseLong(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            long input = Long.parseLong(st.nextToken());
            if (cards.contains(input)) {
                sb.append(1).append(' ');
            }
            else {
                sb.append(0).append(' ');
            }
        }

        System.out.print(sb);
    }
}