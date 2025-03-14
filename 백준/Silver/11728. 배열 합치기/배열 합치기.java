import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < N && j < M) {
            if (A[i] <= B[j]) {
                sb.append(A[i]).append(' ');
                i++;
            }
            else {
                sb.append(B[j]).append(' ');
                j++;
            }
        }

        // A 배열이 남은 경우
        while (i < N) {
            sb.append(A[i]).append(' ');
            i++;
        }
        // B 배열이 남은 경우
        while (j < M) {
            sb.append(B[j]).append(' ');
            j++;
        }

        System.out.print(sb);
    }
}