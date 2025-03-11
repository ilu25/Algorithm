import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] cards = new int[2000_0001];
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(input[i]);
            cards[c + 1000_0000]++;
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int c = Integer.parseInt(input[i]);
            sb.append(cards[c + 1000_0000]).append(" ");
        }
        System.out.print(sb);
    }
}