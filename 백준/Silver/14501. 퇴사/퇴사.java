import java.io.*;

public class Main {
    static int[][] counsel;
    static int max = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        counsel = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            counsel[i][0] = Integer.parseInt(input[0]);
            counsel[i][1] = Integer.parseInt(input[1]);
        }

        DFS(0, 0);
        System.out.println(max);
    }

    // 퇴사일 인덱스: N
    static void DFS(int i, int cur) {
        // 퇴사일 이상인 경우
        if (i >= N) {
            max = Math.max(max, cur);
            return;
        }

        // 퇴사일 전이면 선택 가능 (다음 상담에 현재 금액 추가)
        int nextIdx = i + counsel[i][0];
        if (nextIdx <= N) {
            DFS(nextIdx, cur + counsel[i][1]);
        }

        // 선택 X -> 다음 날짜 상담
        DFS(i + 1, cur);
    }
}

/*
* 9:41 ~ 10:40 (실패)
* [내 풀이]
* - DFS + 백트래킹 (with 방문 배열)
*
* [실패 이후 생각]
* - 선택 O -> 다음 인덱스로 갈 때 이전 인덱스의 금액 받음
* - 선택 X -> 이전 인덱스 + 1 (이 부분 간과!! 문제를 잘못 이해함)
* */