import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] input;
    static int[] arr;
    static boolean[] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[N];
        visited = new boolean[N];

        back(0);
        System.out.print(ans);
    }

    static void back(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = input[i];
                back(depth + 1);
                visited[i] = false;
            }
        }
    }
}