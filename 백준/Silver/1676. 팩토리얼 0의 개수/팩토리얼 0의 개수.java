import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long two = 0;
        long five = 0;

        for (int i = 2; i <= N; i++) {
            int n = i;
            while (n % 2 == 0) {
                two++;
                n /= 2;
            }
            while (n % 5 == 0) {
                five++;
                n /= 5;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.min(two, five));
        System.out.println(sb);
    }

}