import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // int: -21억 ~ 21억
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        
        for (int i = 0; i < n; i++) {
        	coin[i] = Integer.parseInt(br.readLine());
        }
        
	    int count = 0;
        for (int i = n - 1; i >= 0; i--) {
        	if (coin[i] <= k)	{
        		count += k / coin[i];
        		k %= coin[i];
        	}
        }
        sb.append(count).append("\n");
        System.out.print(sb);
    }
    
    public static void main(String args[]) throws Exception {
    	new Main().solution();
    }
}