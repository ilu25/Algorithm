import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Character> trans = new ArrayList<>();
        while (N > 0) {
            trans.add((char) (N % B > 9 ? 'A' + ((N % B) - 10) : '0' + N % B));
            N /= B;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = trans.size() - 1; i >= 0; i--) {
            sb.append(trans.get(i));
        }
        System.out.println(sb);
    }
}