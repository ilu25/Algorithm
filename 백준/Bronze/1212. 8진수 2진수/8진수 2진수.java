import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        // 첫 번째 제외 모든 숫자들 3덩어리로 2진수 변경
        for (int i = s.length() - 1; i > 0; i--) {
            int q = s.charAt(i) - '0';
            for (int j = 0; j < 3; j++) {
                sb.append(q % 2);
                // 0이어도 3번씩 나누도록 하기 (ex. 1 -> 001)
                if (q > 0) {
                    q /= 2;
                }
            }
        }

        // 첫 번째는 2진수 그냥 변경
        int q = s.charAt(0) - '0';
        while (q > 0) {
            sb.append(q % 2);
            q /= 2;
        }

        // 0인 경우
        if (s.equals("0")) {
            sb.append(0);
        }

        sb.reverse();
        System.out.println(sb);
    }
}