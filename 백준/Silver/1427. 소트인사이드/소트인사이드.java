import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int[] numArr = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            numArr[i] = Integer.parseInt(num.substring(i, i + 1));
        }

        // 선택 정렬
        for (int i = 0; i < numArr.length; i++) {
            int maxIndex = i;
            // 최댓값 인덱스 탐색
            for (int j = i + 1; j < numArr.length; j++) {
                if (numArr[j] > numArr[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 최댓값과 맨 앞 swap
            if (numArr[maxIndex] > numArr[i]) {
                int temp = numArr[maxIndex];
                numArr[maxIndex] = numArr[i];
                numArr[i] = temp;
            }
        }

        for (int i : numArr) {
            System.out.print(i);
        }
    }
}