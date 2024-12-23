import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        long price = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            price += (long) a * b;
        }

        if (price == X) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}