import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int start = 0; int end = A.length - 1;
            boolean contained = false;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (target < A[mid]) {
                    end = mid - 1;
                }
                else if (target > A[mid]) {
                    start = mid + 1;
                }
                else {
                    contained = true;
                    break;
                }
            }

            if (contained) {
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }
    }
}