import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(" ".repeat(N - i));
            if (i == 1) {
                sb.append('*');
            }
            else {
                sb.append('*').append(" ".repeat(2*(i-1) - 1)).append('*');
            }
            sb.append("\n");
        }
        sb.append("*".repeat(2*N - 1));
        System.out.println(sb);
    }
}