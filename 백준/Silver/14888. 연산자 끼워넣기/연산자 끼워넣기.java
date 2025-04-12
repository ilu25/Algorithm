import java.io.*;
import java.util.*;

public class Main {
    static int[] numbers;
    static int[] operators = new int[4];  // +, -, x, /
    static int max = -10_0000_0000;
    static int min = 10_0000_0000;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        calculate(numbers[0], 1);
        System.out.print(max + "\n" + min);
    }

    // num: 현재 계산값, id: 다음 숫자 인덱스
    static void calculate(int num, int id) {
        if (id == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0: calculate(num + numbers[id], id + 1); break;
                    case 1: calculate(num - numbers[id], id + 1); break;
                    case 2: calculate(num * numbers[id], id + 1); break;
                    case 3: calculate(num / numbers[id], id + 1); break;
                }

                operators[i]++;
            }
        }
    }
}

/* 
    4:30 ~ 5:00 (X, 재귀 함수 못 만듦)
    [조건]
    - 연산자 우선 순위 X
    - 정수 나눗셈: 몫, 음수 나눗셈: 양수로 바꿔서 몫 만든 뒤 음수로 ch

    [구해야 할 것]
    - 연산식 최대 & 최소
    
    [생각]
    - 항상 -10억 ~ 10억이면 int로 계산
    - 모든 연산자 순서 체크 (브루트 포스) <- 백트래킹 필요!!
*/