import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// counting sort
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 수 카운팅
        // -100만 ~ 100만: 인덱스 0 = -100만, 인덱스 100만 = 0
        boolean[] counting = new boolean[200_0001];  // 중복 없기 때문에 불린 값
        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            counting[index + 100_0000] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counting.length; i++) {
            if (counting[i]) {
                sb.append(i - 100_0000).append("\n");
            }
        }
        System.out.println(sb);
    }
}