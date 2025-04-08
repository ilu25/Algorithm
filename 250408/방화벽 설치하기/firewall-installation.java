import java.util.*;
import java.io.*;

public class Main {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1 , -1};

    static int n;
    static int m;
    static int max = 0;
    static int[][] map;

    static List<int[]> empty = new ArrayList<>();
    static List<int[]> newWalls = new ArrayList<>();
    static List<int[]> fires = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    empty.add(new int[]{i, j});
                }
                else if (map[i][j] == 2) {
                    fires.add(new int[]{i, j});
                }
            }
        }

        comb(0, 0);
        System.out.print(max);
    }

    // 방화벽 3개 선정
    static void comb(int idx, int cnt) {
        // 선정 완료 시 BFS로 빈칸 탐색
        if (cnt == 3) {
            fire();
            return;
        }

        // 백트래킹
        for (int i = idx; i < empty.size(); i++) {
            newWalls.add(new int[] {empty.get(i)[0], empty.get(i)[1]});
            comb(i + 1, cnt + 1);
            newWalls.remove(newWalls.size() - 1);
        }
    }

    static void fire() {
        // 초기화 (2차원 배열은 직접 deep copy)
        int[][] curMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            curMap[i] = map[i].clone();
        }

        // 새로운 방화벽 설치
        for (int[] w : newWalls) {
            curMap[w[0]][w[1]] = 1;
        }

        // 불 확산
        for (int[] f : fires) {
            Queue<int[]> q = new LinkedList();
            q.add(f);

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int a = 0; a < 4; a++) {
                    int nx = cur[0] + dx[a];
                    int ny = cur[1] + dy[a];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    if (curMap[nx][ny] == 0) {
                        curMap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j  = 0; j < m; j++) {
                if (curMap[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }
}

/* 
    8:49 ~ 10:00 (X)
    - 문제: 방화벽으로 상하좌우로 번지지 않는 영역 최대
    - 그리디
    : 빈칸에 3개 넣고 BFS 수행 -> 0 개수 구하기
*/