import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> input = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            input.add(i);
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!input.isEmpty()) {
            idx = (idx + K - 1) % input.size();
            sb.append(input.remove(idx));
            if (!input.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}