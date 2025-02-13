import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 3:44 ~ 4:00
        boolean[] isPrime = new boolean[100_0001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= 1000; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = 2; i * j <= 100_0000; j++) {
                isPrime[i * j] = false;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            int a = 0;
            int b = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i] && isPrime[n - i]) {
                    a = i;
                    b = n - i;
                    break;
                }
            }

            if (a != 0 && b != 0) {
                sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
            }
            else {
                sb.append("Goldbach's conjecture is wrong.\n");
            }

            n = Integer.parseInt(br.readLine());
        }
        System.out.print(sb);
    }
}