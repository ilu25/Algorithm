import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = "";
        while ((s = br.readLine()) != null) {
        	BigInteger n = new BigInteger(s);
            BigInteger oneNum = BigInteger.ZERO;
            
            while (true) {
            	oneNum = oneNum.multiply(BigInteger.TEN).add(BigInteger.ONE);
            	if (oneNum.mod(n).equals(BigInteger.ZERO)) {
            		sb.append(oneNum.toString().length()).append('\n');
            		break;
            	}
            }
        }
        
        System.out.println(sb);
    }
    
    public static void main(String args[]) throws Exception {
    	new Main().solution();
    }
}