import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int N;
	static int S;
	static int ans = 0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        DFS(0, 0);
        
        // 공집합 제외 (아무 정수도 선택하지 않는 경우)
        if (S == 0) {
        	ans--;
        }
        System.out.print(ans);
    }
    
    static void DFS(int idx, int sum) {
    	if (idx == N) {
    		if (sum == S) {
    			ans++;
    		}
    		return;
    	}
    	
    	DFS(idx + 1, sum + arr[idx]);
    	DFS(idx + 1, sum);
    }
}

/*
 * N: 정수 개수 (1 ~ 20)
 * S: 정수 합 (-100만 ~ 100만)
 * -> 부분수열의 합 = S인 경우의 수
 * 
 * [풀이]
 * (10분) 브루트 포스인 건 알지만, 어떤 식으로 부분 수열을 구성해야 할지 감이 안 옴
 * -> 수열 생각할 때 원소 개수로 따져서 트리 구조 생각 못함
 * 
 * 로직: (인덱스마다 원소를 뽑을지/말지 = DFS) + (S = 0일 때 공집합인 경우는 빼야 함)
*/
