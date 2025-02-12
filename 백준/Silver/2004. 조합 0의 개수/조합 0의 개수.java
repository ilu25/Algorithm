import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // 분자
        int bj_two = two_count(n);
        int bj_five = five_count(n);

        // 분모
        int bm_two = two_count(m) + two_count(n - m);
        int bm_five = five_count(m) + five_count(n - m);

        int two = bj_two - bm_two;
        int five = bj_five - bm_five;
        
        StringBuilder sb = new StringBuilder();
        sb.append(Math.min(two, five));
        System.out.println(sb);
    }

    static int two_count(int n) {
        int count = 0;
        while (n >= 2) {
            count += n / 2;
            n /= 2;
        }
        return count;
    }

    static int five_count(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}