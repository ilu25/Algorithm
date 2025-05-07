import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우 이동을 위한 x좌표 변화량
    static int[] dy = {0, 0, -1, 1};  // 상하좌우 이동을 위한 y좌표 변화량
    static int N, M;

    static int[] calculatePower() {
        int totalWhite = 0, totalBlue = 0;

        // 전체 격자를 순회하며 각 진영의 전투력 계산
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int groupSize = dfs(i, j, board[i][j]);
                    if (board[i][j] == 'W') {
                        totalWhite += groupSize * groupSize;
                    } else {
                        totalBlue += groupSize * groupSize;
                    }
                }
            }
        }

        return new int[]{totalWhite, totalBlue};
    }

    static int dfs(int x, int y, char color) {
        int count = 1;  // 현재 위치의 병사 카운트
        visited[x][y] = true;

        // 상하좌우 인접한 같은 색상 병사 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 유효한 범위이고 같은 색상이면 탐색 진행
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] == color) {
                count += dfs(nx, ny, color);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[M][N];
        visited = new boolean[M][N];

        // 전쟁터 상태 입력
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int[] result = calculatePower();
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.print(sb);
    }
}
