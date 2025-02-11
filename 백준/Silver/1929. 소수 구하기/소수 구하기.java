import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            for (int j = 2; i * j <= N; j++) {
                primes[i * j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i < primes.length; i++) {
            if (primes[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}