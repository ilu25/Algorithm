import java.util.Scanner;

public class Main {
    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] coin = new long[11];
        
        for (int i = 0; i < n; i++) {
        	coin[i] = sc.nextLong();
        }
        
        long l = 0;
        long count = 0;
        for (int i = n - 1; i >= 0; i--) {
        	if (l == k) {
        		break;
        	}
        	while (l + coin[i] <= k)	{
        		l += coin[i];
        		count++;
        	}
        }
        sb.append(count).append("\n");
        System.out.print(sb);
    }
    
    public static void main(String args[]) throws Exception {
    	new Main().solution();
    }
}