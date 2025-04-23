import java.io.*;
import java.util.*;

public class Main {
	static int F, S, G, U, D;
	static int min = -1;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		F = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);
		G = Integer.parseInt(input[2]);
		U = Integer.parseInt(input[3]);
		D = Integer.parseInt(input[4]);
		visited = new boolean[F + 1];	// 1 ~ F층
		
		BFS();
		
		StringBuilder sb = new StringBuilder();
		if (min != -1) {
			sb.append(min);
		}
		else {
			sb.append("use the stairs");
		}
		System.out.print(sb);
	}
	
	static void BFS() {
		Queue<Integer> stairs = new LinkedList<>();
		stairs.offer(S);
		int cnt = 0;
		
		while (!stairs.isEmpty()) {
			// 업 & 다운해서 도착한 층들 확인 -> 횟수 증가
			int size = stairs.size();
			while (size > 0) {
				size--;
				int stair = stairs.poll();
				
				if (stair == G) {
					min = cnt;
					return;
				}
				
				// 업 & 다운
				if (stair < 1 || stair > F) continue;
				if (visited[stair]) continue;
				
				visited[stair] = true;
				
				stairs.offer(stair + U);
				stairs.offer(stair - D);
			}
			cnt++;
		}
	}
}

/* 
 * 11:11 ~ 11:47
 * - BFS로 G층의 최소 버튼 수 구하기
 * - U 또는 D가 0인 경우 주의하기
 * - visited로 부하 감소
 * 
 * [과정]
 * - 메모리 초과
 * -> 정답 풀이 참고 (큐 사이즈만큼 확인 후 횟수 증가시키기)
 */
