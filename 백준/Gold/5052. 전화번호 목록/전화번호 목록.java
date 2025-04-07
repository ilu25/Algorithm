import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] phone_numbers = new String[N];

            for (int i = 0; i < N; i++) {
                phone_numbers[i] = br.readLine();
            }
            Arrays.sort(phone_numbers);

            if (isConsistent(N, phone_numbers)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isConsistent(int N, String[] phone_number) {
        // 오름차순 정렬된 상태에서 현재 문자열이 다음 문자열의 접두어인지 확인
        for (int i = 0; i < N - 1; i++) {
            if (phone_number[i + 1].startsWith(phone_number[i])) {
                return false;
            }
        }
        return true;
    }

}