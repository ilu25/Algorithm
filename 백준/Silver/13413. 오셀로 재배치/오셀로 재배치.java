import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void solution() throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
        	int n = Integer.parseInt(br.readLine());
        	String start = br.readLine();
        	String end = br.readLine();
        	
        	int w = 0; int b = 0;
        	for (int j = 0; j < n; j++) {
        		if (start.charAt(j) != end.charAt(j)) {
	        		if (start.charAt(j) == 'B') {
	        			b++;
	        		}
	        		else {
	        			w++;
	        		}
        		}
        	}
        	System.out.println(Math.min(w, b) + Math.abs(w - b));
        }
    }
    
    public static void main(String args[]) throws Exception {
    	new Main().solution();
    }
}