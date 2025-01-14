import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 11:36 ~ 11:56
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] cordinate = new LinkedList[20_0001];
        for (int i = 0; i < cordinate.length; i++) {
            cordinate[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cordinate[x + 10_0000].add(y);
        }

        for (LinkedList<Integer> yList : cordinate) {
            Collections.sort(yList);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cordinate.length; i++) {
            while (!cordinate[i].isEmpty()) {
                sb.append(i - 10_0000).append(" ").append(cordinate[i].poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}