import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] lines = new int[K];
        long start = 1;
        long end = 0;
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, lines[i]);
        }

        long max = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            int count = 0;
            for (int line : lines) {
                count += (int) (line / mid);
            }

            if (count < N) {
                end = mid - 1;
            }
            else {  // N개보다 많이 만드는 것도 N개 만드는 것
                max = Math.max(max, mid);
                start = mid + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max);
        System.out.print(sb);
    }
}