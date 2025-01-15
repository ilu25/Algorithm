import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String>[] members = new ArrayList[201];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());

            if (members[age] == null) {
                members[age] = new ArrayList<>();
            }
            members[age].add(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < members.length; i++) {
            if (members[i] != null) {
                while (!members[i].isEmpty()) {
                    sb.append(i).append(" ").append(members[i].remove(0)).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}