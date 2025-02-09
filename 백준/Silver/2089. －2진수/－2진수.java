import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        if (N == 0) {
            sb.append(0);
        }
        while (N != 0) {
            int r = N % -2;
            N /= -2;
            if (r == -1) {
                N++;
                r = 1;
            }
            sb.append(r);
        }
        sb.reverse();
        System.out.println(sb);
    }
}