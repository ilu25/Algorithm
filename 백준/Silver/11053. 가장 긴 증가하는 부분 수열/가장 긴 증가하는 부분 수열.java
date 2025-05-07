import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] A = new int[N];
    	int[] dp = new int[N];
    	   	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for (int i = 0; i < N; i++) {
    		// 초기화
			dp[i] = 1;	
		    
			// 0 ~ i 이전 원소들 탐색
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		// 최대 길이 탐색 
		int max = 1;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
    	System.out.print(max);
    }
}

/* 
 * 11:02 ~ 11:46 (X)
 * [문제]
 * - 답: 수열 A에서 가장 길게 증가하는 부분 수열 길이
 * - 조건: 수열 크기 = 1 ~ 1000, 수열 요소 = 1 ~ 1000
 * 
 * [정답 풀이]
 * - 각 원소마다 증가하는 길이 저장
*/
