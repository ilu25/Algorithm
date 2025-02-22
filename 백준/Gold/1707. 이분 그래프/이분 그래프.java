import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] group;    // 두 집합
    static boolean isSame = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            for (int j = 1; j <= V; j++) {
                list[j] = new ArrayList<>();
            }
            group = new int[V + 1];

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
                list[v].add(u);
            }

            for (int j = 1; j <= V; j++) {
                dfs(j);
            }
            sb.append(isSame ? "NO" : "YES").append('\n');
            isSame = false;
        }
        System.out.println(sb);
    }

    static void dfs(int i) {
        visited[i] = true;

        for (int v : list[i]) {
            if (!visited[v]) {
                group[v] = (group[i] + 1) % 2;
                dfs(v);
            }
            else if (group[i] == group[v]) {
                isSame = true;
                break;
            }
        }
    }
}