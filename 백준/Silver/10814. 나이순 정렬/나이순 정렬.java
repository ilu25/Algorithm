import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder[] members = new StringBuilder[201];

        for (int i = 1; i < members.length; i++) {
            members[i] = new StringBuilder();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[age].append(age).append(" ").append(name).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < members.length; i++) {
            sb.append(members[i]);
        }
        System.out.println(sb);
    }
}