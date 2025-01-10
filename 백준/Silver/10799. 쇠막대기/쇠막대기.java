import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다른 사람 코드 ver.
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int ans = 0;
        int openCnt = 0;

        for (int i = 0 ; i < input.length ; i++) {
            if (input[i] == '(') {
                openCnt++;
            }
            else {
                openCnt--;
                if (input[i - 1] == ')') {
                    ans++;
                }
                else {
                    ans += openCnt;
                }
            }
        }
        System.out.println(ans);
    }
}