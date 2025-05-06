import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[] A = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		A[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int s = 0, e = 0, sum = 0, ans = 0;
    	while (true) {
    		if (sum >= M) {
				sum -= A[s++];
			}
    		// 마지막 원소까지 더했는데 sum이 M보다 작은 경우
    		else if (e == N) {
    			break;
    		}
			else {
				sum += A[e++];
			}
    		
    		if (sum == M) {
    			ans++;
    		}
		}
    	
    	System.out.print(ans);
    }
}

/*
 * - i부터 j까지 수열의 합 = M인 경우의 수
 * - N: 수열 개수 (1 ~ 10,000)
 * - M: 합 (1 ~ 3억)
 * - A[i]: 수열 원소 (1 ~ 29,999) 
 * 
 * [풀이]
 * - 투 포인터 ver.
*/
