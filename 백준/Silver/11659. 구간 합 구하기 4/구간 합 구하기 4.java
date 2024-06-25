import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
      
      Scanner scanner = new Scanner(System.in);
      int length = scanner.nextInt();
      int count = scanner.nextInt();
      int[] arrSum = new int[length];
      
      // 배열 값 저장장
      arrSum[0] = scanner.nextInt();
      for (int i = 1; i < length; i++) {
          arrSum[i] = arrSum[i - 1] + scanner.nextInt();
      }
      
      // 횟수마다 구간 합 구하기기
      for (int i = 0; i < count; i++) {
          int start = scanner.nextInt() - 1;
          int end = scanner.nextInt() - 1;
          
          int answer;
          if (start == 0) {
              answer = arrSum[end];
          }
          else {
              answer = arrSum[end] - arrSum[start - 1];
          }
 
          System.out.println(answer);
      }
    }
}