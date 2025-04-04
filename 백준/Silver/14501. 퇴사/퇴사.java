import java.io.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            int price = Integer.parseInt(input[1]);

            if (i + time <= N) {
                dp[i + time] = Math.max(dp[i + time], dp[i] + price);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[N]);
    }
}

/*
* [DP 버전]
* 입력 받을 때부터,
* - 선택 가능 -> 선택한 금액이나 현재에서 추가된 금액 중 큰 것
* - 선택 안 함 -> 현재나 다음 상담의 금액 중 큰 걸로 책정
* */