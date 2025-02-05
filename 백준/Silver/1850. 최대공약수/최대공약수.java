import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcd = a > b ? gcd(a, b) : gcd(b, a);

        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < gcd; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        while (b > 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}