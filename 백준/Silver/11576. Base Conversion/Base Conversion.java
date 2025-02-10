import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // A진법 -> 10진법
        int num = 0;
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            num += (int) (a * Math.pow(A, m - 1 - i));
        }

        // 10진법 -> B진법
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % B);
            num /= B;
        }
        for (int i = list.size() - 1; i > 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        sb.append(list.get(0));

        System.out.println(sb);
    }
}