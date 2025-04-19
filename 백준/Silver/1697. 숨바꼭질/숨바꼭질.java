import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[10_0001];
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        BFS();
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == K) {
                System.out.println(p[1]);
                return;
            }

            int next = p[0] - 1;
            if (next >= 0 && !visited[next]) {
                q.add(new int[] {next, p[1] + 1});
                visited[next] = true;
            }

            next = p[0] + 1;
            if (next <= 100000 && !visited[next]) {
                q.add(new int[] {next, p[1] + 1});
                visited[next] = true;
            }

            next = p[0] * 2;
            if (next <= 100000 && !visited[next]) {
                q.add(new int[] {next, p[1] + 1});
                visited[next] = true;
            }
        }
    }
}

/*
* 11:56 ~ 12:34
* - 걷기: +-1
* - 순간 이동: + 2*X
*
* [풀이]
* - DFS 백트래킹, 매 함수마다 시간 같이 보내기
* - 동생에 도착하면 min값 갱신
* -> 스택 오버 플로우..
*
* [정답]
* 최단 시간은 BFS로!
* */