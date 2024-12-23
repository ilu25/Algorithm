import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        B += C;
        while (B >= 60) {
            A++;
            B -= 60;
        }
        A %= 24;

        System.out.printf("%d %d", A, B);
    }
}