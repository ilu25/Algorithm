import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        List<Integer> list = new ArrayList<>();
        int D = A;
        while (!list.contains(D)) {
            list.add(D);

            int temp = D;   // 이전 값 저장
            D = 0;  // 합
            while (temp > 0) {
                int n = temp % 10;
                D += Math.pow(n, P);
                temp /= 10;
            }
        }

        System.out.print(list.indexOf(D));
    }
}