import java.io.*;
import java.util.*;

class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, -1, 0, 1};
    static int N;
    static int count;
    static List<Integer> danji = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (map[i][j] == '1' && !visited[i][j]) {
                    DFS(i, j);
                    danji.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(danji.size()).append('\n');
        Collections.sort(danji);
        for (int count : danji) {
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    static void DFS(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= N) {
            return;
        }

        if (map[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true;
            count++;
            for (int v = 0; v < 4; v++) {
                DFS(i + y[v], j + x[v]);
            }
        }
    }
}