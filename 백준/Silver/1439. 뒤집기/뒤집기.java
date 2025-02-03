import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[] bundle = new int[2];  // 0, 1 덩어리 개수
        int isNow = S.charAt(0) - '0';
        bundle[isNow]++;

        for (int i = 1; i < S.length(); i++) {
            if (isNow != S.charAt(i) - '0') {
                isNow = S.charAt(i) - '0';
                bundle[isNow]++;
            }
        }

        System.out.println(Math.min(bundle[0], bundle[1]));
    }
}