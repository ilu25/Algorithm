import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int cc = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cc++;
                dfs(i);
            }
        }

        System.out.print(cc);
    }

    static void dfs(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;

        for (int v : list[i]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}