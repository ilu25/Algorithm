import java.io.*;
import java.util.*;

class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            matrix = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (matrix[i][j] == 1 && !visited[i][j]) {
                        count++;
                        DFS(i, j);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    static void DFS(int i, int j) {
        // 범위 확인
        if (i < 0 || j < 0 || i >= h || j >= w) {
            return;
        }

        if (matrix[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            // 전 행
            DFS(i - 1, j - 1);
            DFS(i - 1, j);
            DFS(i - 1, j + 1);

            // 양 옆
            DFS(i, j - 1);
            DFS(i, j + 1);

            // 다음 행
            DFS(i + 1, j - 1);
            DFS(i + 1, j);
            DFS(i + 1, j + 1);
        }
    }
}