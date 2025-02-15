import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 앞에서 10 제외하고 맨 앞이 0 또는 1일 때
        long[][] dp = new long[N + 1][2];
        dp[1][0] = 1;   // 1

        if (N > 1) {
            dp[2][0] = 1;   // 10
        }

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N][0] + dp[N][1]);
        System.out.print(sb);
    }
}