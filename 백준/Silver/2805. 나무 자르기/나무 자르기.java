import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        int min = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        while (min < max) {
            long sum = 0;
            int H = (min + max) / 2;

            for (int tree : trees) {
                sum += Math.max(tree - H, 0);
            }

            if (sum < M) {
                max = H;
            }
            else {
                min = H + 1;
            }
        }

        System.out.print(min - 1);
    }
}