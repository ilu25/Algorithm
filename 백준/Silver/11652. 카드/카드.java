import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // ~ 10만

        HashMap<Long, Integer> cards = new HashMap<>();
        long maxNum = 0;
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            cards.put(num, cards.getOrDefault(num, 0) + 1);

            if (cards.get(num) > maxCount) {
                maxCount = cards.get(num);
                maxNum = num;
            }
            else if (cards.get(num) == maxCount) {
                maxNum = Math.min(num, maxNum);
            }
        }

        System.out.println(maxNum);
    }
}