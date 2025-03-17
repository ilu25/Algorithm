import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] students = new int[A];
        for (int i = 0; i < A; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 총감독관
        for (int i = 0; i < A; i++) {
            students[i] -= B;
        }
        long ans = A;

        // 부감독관
        for (int i = 0; i < A; i++) {
            if (students[i] <= 0) {
                continue;
            }
            ans += students[i] % C == 0 ? students[i] / C : students[i] / C + 1;
        }

        System.out.print(ans);
    }
}