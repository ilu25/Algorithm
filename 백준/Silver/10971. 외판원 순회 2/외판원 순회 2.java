import java.io.*;
import java.util.*;

public class Main {
    static int[][] W;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int N;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        W = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		W[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int i = 0; i < N; i++) {
        	visited = new boolean[N];
        	visited[i] = true;
        	DFS(i, i, 0, 1);
        }
        
        System.out.print(min);
	}
	
	static void DFS(int start, int now, int sum, int count) {
		if (count == N && W[now][start] != 0) {
			// 시작점으로 가는 길 확인
			min = Math.min(min, sum + W[now][start]);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]|| W[now][i] == 0) continue;
			visited[i] = true;
			DFS(start, i, sum + W[now][i], count + 1);
			visited[i] = false;
		}
	}
}
/* 
 * 10:30 ~ 
 * [문제]
 * - W[i][j] : i도시에서 j도시 가는 비용 (방향 O)
 * - W[i][j] = 0 : 갈 수 없음
 * - 구해야 할 것: 모든 도시 거쳐 다시 돌아오는 데 최소 비용 (순회 가능한 경우만 주어짐)
 * 
 * [풀이]
 * - 백트래킹으로 방문한 노드 개수와 함께 탐색
 * 
 * [과정]
 * - ~ 11:00 : 답 다름
 * - ~ 11:30 : 다시 돌아와야 하는 걸 어떻게 구현할지 모름 -> 시작점 계속 달고 다니기
 */