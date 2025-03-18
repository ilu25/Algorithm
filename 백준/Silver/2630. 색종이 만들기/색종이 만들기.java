import java.io.*;

public class Main {
    static int[][] papers;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        papers = new int[N][N];

        // 색종이 입력 받기
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                papers[i][j] = Integer.parseInt(input[j]);
            }
        }

        divide(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(white).append("\n");
        sb.append(blue);
        System.out.print(sb);
    }

    static void divide(int x, int y, int N) {
        // 종료 조건
        if (N < 1) {
            return;
        }

        // 전체 같은 색인지 확인
        boolean isSame = true;
        int nowColor = papers[x][y];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (nowColor != papers[x+i][y+j]) {
                    isSame = false;
                    break;
                }
            }
        }

        // 전체 같은 색이면 +1
        if (isSame) {
            if (nowColor == 0) {
                white++;
            }
            else {
                blue++;
            }
        }
        else {
            // N/2 x N/2 사이즈로 4번 반복
            divide(x, y, N/2);
            divide(x + N/2, y, N/2);
            divide(x, y + N/2, N/2);
            divide(x + N/2, y + N/2, N/2);
        }
    }
}