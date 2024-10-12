import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] isPrime = new boolean[N + 1];

        for (int i = 2; i < N + 1; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!isPrime[i]) {
                continue;
            }
            // i의 배수 = 소수 X
            for (int j = i * 2; j <= N; j += i) {
                if (!isPrime[j]) {
                    continue;
                }
                isPrime[j] = false;
            }
        }
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}