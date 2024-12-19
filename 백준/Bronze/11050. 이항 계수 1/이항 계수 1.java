import java.util.Scanner;

class Main {
    static int N, K;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N + 1][N + 1];

        // 초기화
        for (int i = 1; i <= N; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;    // 이것 때문에 배열 N x N
        }

        // 점화식으로 배열 완성
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
            }
        }

        System.out.println(D[N][K]);
    }
}