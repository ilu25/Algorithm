import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) >= 'A' ? N.charAt(i) - 'A' + 10 : N.charAt(i) - '0';
            ans += (int) (num * Math.pow(B, N.length() - i - 1));
        }
        System.out.println(ans);
    }
}