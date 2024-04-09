import java.util.Scanner;

public class Main {
    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
        	int n = sc.nextInt();
        	String start = sc.next();
        	String end = sc.next();
        	
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
        sc.close();
    }
    
    public static void main(String args[]) throws Exception {
    	new Main().solution();
    }
}