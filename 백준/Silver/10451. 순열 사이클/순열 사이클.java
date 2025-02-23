import java.io.*;
import java.util.*;

class Main {
    static int[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            graph = new int[N + 1];
            visited = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    count++;
                    DFS(j);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void DFS(int v) {
        if (!visited[v]) {
            visited[v] = true;
            DFS(graph[v]);
        }
    }
}