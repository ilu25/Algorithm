import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int[] ans = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            char[] cArr = str.toCharArray();
            for (char c : cArr) {
                if (c >= 'a' && c <= 'z') {
                    ans[0]++;
                } else if (c >= 'A' && c <= 'Z') {
                    ans[1]++;
                } else if (c >= '0' && c <= '9') {
                    ans[2]++;
                } else if (c == ' ') {
                    ans[3]++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i : ans) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);

            Arrays.fill(ans, 0);
        }
    }
}