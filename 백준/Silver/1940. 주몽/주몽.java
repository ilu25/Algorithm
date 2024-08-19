import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(arr);

        // 투 포인터
        int count = 0;
        int start = 0;
        int end = N - 1;
        while (start < end) {
            if (arr[start] + arr[end] == M) {
                count++;
                start++;
                end--;
            }
            else if (arr[start] + arr[end] < M) {
                start++;
            }
            else {
                end--;
            }
        }
        System.out.println(count);
    }
}