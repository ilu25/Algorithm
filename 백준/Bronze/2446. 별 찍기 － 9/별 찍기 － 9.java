import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(i)).append("*".repeat(2 * (N - i) - 1)).append("\n");
        }
        for (int i = 2; i <= N; i++) {
            sb.append(" ".repeat(N - i)).append("*".repeat(2 * i - 1)).append("\n");
        }
        System.out.println(sb);
    }
}