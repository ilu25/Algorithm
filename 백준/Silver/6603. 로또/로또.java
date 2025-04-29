import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[] numbers;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	while (true) {
    		st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
    		numbers = new int[k];
    		result = new int[6];
    		
    		if (k == 0) {
    			break;
    		}
    		
    		for (int i = 0; i < k; i++) {
    			numbers[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		DFS(0, 0);
    		sb.append("\n");
    	}
    	
    	System.out.print(sb);
    }
    
    // idx: 시작 인덱스, depth: 0 ~ 5 (6 되면 출력)
    static void DFS(int idx, int depth) {
    	if (depth == 6) {
    		for (int num : result) {
    			sb.append(num).append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i = idx; i < k; i++) {
    		result[depth] = numbers[i];  
    		DFS(i + 1, depth + 1);
    	}
    }
}

/* 
 * 다른 풀이: DFS마다 배열 저장하지 않고, 시작 인덱스만 가지고 for문으로 배열 갱신
 */