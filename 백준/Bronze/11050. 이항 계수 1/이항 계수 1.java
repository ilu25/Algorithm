import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int numerator = factorial(N);
        int denominator = factorial(N - K) * factorial(K);
        int combination = numerator / denominator;

        System.out.println(combination);
    }

    private static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}