import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] isVisitedInDFS;
    static boolean[] isVisitedInBFS;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        isVisitedInDFS = new boolean[N + 1];
        isVisitedInBFS = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        DFS(V);
        sb.append("\n");
        BFS(V);
        System.out.print(sb);
    }

    static void DFS(int v) {
        if (isVisitedInDFS[v]) {
            return;
        }
        isVisitedInDFS[v] = true;
        sb.append(v).append(" ");

        for (int i : graph[v]) {
            if (!isVisitedInDFS[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (!isVisitedInBFS[v]) {
                isVisitedInBFS[v] = true;
                sb.append(v).append(" ");
                queue.addAll(graph[v]);
            }
        }
    }
}