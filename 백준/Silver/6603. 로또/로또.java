import java.io.*;
import java.util.*;

public class Main {
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int k;
    	
    	while ((k = Integer.parseInt(st.nextToken())) != 0) {
    		numbers = new int[k];
    		
    		for (int i = 0; i < k; i++) {
    			numbers[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		for (int i = 0; i < k; i++) {
    			List<Integer> list = new ArrayList<>();
    			list.add(numbers[i]);
    			DFS(k, i, 1, list);
    		}
    		
    		sb.append("\n");
    		st = new StringTokenizer(br.readLine());
    	}
    	
    	System.out.print(sb);
    }
    
    static void DFS(int k, int idx, int count, List<Integer> list) {
    	if (count == 6) {
    		for (int num : list) {
    			sb.append(num).append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i = idx + 1; i < k; i++) {
    		list.add(numbers[i]);
    		DFS(k, i, count + 1, list);
    		list.remove(list.size() - 1);
    	}
    }
}

/* 
 * 9:40 ~ 10:25
 * - k개 수 중 6개 고르는 모든 경우의 수 (사전순 출력)
 * - 0이 입력되기 전까지 반복
 * 
 * [풀이]
 * - DFS마다 배열들 저장
 */