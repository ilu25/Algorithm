import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String sentence = sc.nextLine();
		String encoding = sc.nextLine();
		
		for (int i = 0, j = 0; i < sentence.length(); i++, j++) {
			if (j == encoding.length()) {
				j = 0;
			}
			if (sentence.charAt(i) == ' ') {
				System.out.print(" ");			
				continue;
			}
			if (sentence.charAt(i) <= encoding.charAt(j)) {
				System.out.print((char)(sentence.charAt(i) - encoding.charAt(j) + 26 + 'a' - 1));
				continue;
			}
			System.out.print((char)(sentence.charAt(i) - encoding.charAt(j) + 'a' - 1));
		}
		sc.close();
	}
}