import java.io.*;

public class Main {
    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                video[i][j] = line.charAt(j) - '0';
            }
        }

        compress(0, 0, N);
        System.out.print(sb);
    }

    static void compress(int x, int y, int N) {
        int now = video[x][y];
        boolean isDifferent = false;

        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (now != video[i][j]) {
                    isDifferent = true;
                    break;
                }
            }
        }

        if (isDifferent) {
            sb.append("(");
            compress(x, y, N/2);
            compress(x, y + N/2, N/2);
            compress(x + N/2, y, N/2);
            compress(x + N/2, y + N/2, N/2);
            sb.append(")");
        }
        else {
            sb.append(now);
        }

    }
}