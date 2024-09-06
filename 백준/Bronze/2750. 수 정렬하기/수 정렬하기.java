import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ascArr = new int[N];

        for (int i = 0; i < N; i++) {
            ascArr[i] = Integer.parseInt(br.readLine());
        }

        // 버블 정렬
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (ascArr[j] > ascArr[j + 1]) {
                    int temp = ascArr[j];
                    ascArr[j] = ascArr[j + 1];
                    ascArr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(ascArr[i]);
        }
    }
}