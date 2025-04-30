import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxSum = 0;
        for (int i = 0; i < n - 2; i++) {  
            for (int j = i + 1; j < n - 1; j++) {  
                for (int k = j + 1; k < n; k++) {  
                    int currentSum = cards[i] + cards[j] + cards[k];
                    if (currentSum <= m) {
                        maxSum = Math.max(maxSum, currentSum);
                    }
                }
            }
        }

        System.out.print(maxSum);
    }
}