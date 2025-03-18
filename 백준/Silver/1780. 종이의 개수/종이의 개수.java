import java.io.*;

public class Main {
    static int[][] papers;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        papers = new int[N][N];

        // 종이 입력 받기
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                papers[i][j] = Integer.parseInt(input[j]);
            }
        }

        divide(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(minus).append("\n");
        sb.append(zero).append("\n");
        sb.append(plus);
        System.out.print(sb);
    }

    static void divide(int x, int y, int N) {
        // 전체 같은 색이면 +1
        int color = papers[x][y];
        if (isSame(x, y, N)) {
            if (color == -1) {
                minus++;
            }
            else if (color == 0) {
                zero++;
            }
            else {
                plus++;
            }
            return;
        }

        // N/3 x N/3 사이즈로 9번 반복
        int newN = N / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(x + newN * i, y + newN * j, newN);
            }
        }
    }

    static boolean isSame(int x, int y, int N) {
        int color = papers[x][y];
        for (int i = x; i < x+N; i++) {
            for (int j = y; j < y+N; j++) {
                if (color != papers[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}