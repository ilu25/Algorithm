import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        System.out.print(bSearch(n));
    }
    
    public static long bSearch(long n) {
    	long start = 0;
    	long end = n;
    	long answer = 0;
    	
    	while (start <= end) {
    		long mid = (start + end) / 2;
    		if (n <= Math.pow(mid, 2)) {
    			answer = mid;
    			end = mid - 1;
    		}
    		else {
    			start = mid + 1;
    		}
    	}
    	return answer;
    }
    
    public static void main(String args[]) throws Exception {
    	new Main().solution();
    }
}
