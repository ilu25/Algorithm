import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int F = Integer.parseInt(input[0]);
		int S = Integer.parseInt(input[1]);
		int G = Integer.parseInt(input[2]);
		int U = Integer.parseInt(input[3]);
		int D = Integer.parseInt(input[4]);
		boolean[] visited = new boolean[F + 1];	// 1 ~ F층
		
		Queue<int[]> stairs = new LinkedList<>();
		stairs.offer(new int[] {S, 0});
		visited[S] = true;
		int min = -1;
		
		while (!stairs.isEmpty()) {
			int[] stair = stairs.poll();
			
			if (stair[0] == G) {
				min = stair[1];
				break;
			}
			
			// 업 & 다운
			int[] next = new int[] {stair[0] + U, stair[0] - D};
			if (U != 0 && next[0] <= F) {
				if (!visited[next[0]]) {
					visited[next[0]] = true;
					stairs.offer(new int[] {next[0], stair[1] + 1});
				}
			}
			if (D != 0 && next[1] >= 1) {
				if (!visited[next[1]]) {
					visited[next[1]] = true;
					stairs.offer(new int[] {next[1], stair[1] + 1});
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if (min != -1) {
			sb.append(min);
		}
		else {
			sb.append("use the stairs");
		}
		System.out.print(sb);
	}
}

/* 
 * 11:11 ~ 12:18
 * - BFS로 G층의 최소 버튼 수 구하기
 * - U 또는 D가 0인 경우 주의하기
 * - visited로 부하 감소
 * 
 * [과정]
 * - ~34: 메모리 초과
 * -> visited 업데이트를 안 함..
 */
