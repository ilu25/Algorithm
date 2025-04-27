import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int bagCount = 0;

        StringBuilder sb = new StringBuilder();
        while (n >= 0) {
            if (n % 5 == 0) {
                bagCount += n / 5;
                sb.append(bagCount);
                System.out.print(sb);
                return;
            }
            bagCount++;
            n -= 3;  // 3kg 봉지 하나 추가
        }

        // 정확히 나눌 수 없는 경우
        sb.append(-1);
        System.out.print(sb);
    }
}