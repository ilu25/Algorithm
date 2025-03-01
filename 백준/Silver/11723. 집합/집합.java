import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int S = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("all")) {
                S = (1 << 21) - 1;
            }
            else if (s.equals("empty")) {
                S = 0;
            }
            else {
                int x = Integer.parseInt(st.nextToken());
                switch (s) {
                    // x번째 위치 비트 1로 설정
                    case "add":
                        S |= (1 << x);
                        break;
                    // x번째 위치 비트만 0으로 설정
                    case "remove":
                        S &= ~(1 << x);
                        break;
                    // x번째 위치 비트가 0이 아니면 1 출력
                    case "check":
                        sb.append((S & (1 << x)) != 0 ? 1 : 0).append('\n');
                        break;
                    // x번째 위치 비트 전환 (1 XOR 1 = 0, 0 XOR 1 = 1)
                    case "toggle":
                        S ^= (1 << x);
                        break;
                }
            }
        }
        System.out.println(sb);
    }
}