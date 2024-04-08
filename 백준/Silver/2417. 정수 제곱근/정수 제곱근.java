import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        long q = (long)Math.sqrt(n);

        if((q*q) < n) q++;

        System.out.println(q);
    }
    
    public static void main(String args[]) throws Exception {
    	new Main().solution();
    }
}