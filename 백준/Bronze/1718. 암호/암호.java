import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] sentence = br.readLine().toCharArray();
		char[] encoding = br.readLine().toCharArray();
		
		for (int i = 0, j = 0; i < sentence.length; i++, j++) {
			if (j == encoding.length) {
				j = 0;
			}
			if (sentence[i] == ' ') {
				System.out.print(" ");			
				continue;
			}
			if (sentence[i] <= encoding[j]) {
				System.out.print((char)(sentence[i] - encoding[j] + 26 + 'a' - 1));
				continue;
			}
			System.out.print((char)(sentence[i] - encoding[j] + 'a' - 1));
		}
	}
}