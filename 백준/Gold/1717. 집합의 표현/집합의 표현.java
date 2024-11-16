import java.util.Scanner;

public class Main {
    static int[] parent;    // 대표 노드 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (question == 0) {    // union
                union(a, b);
            }
            else {  // 두 원소 같은지 확인
                boolean result = checkSame(a, b);
                if (result) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        // 대표 노드 찾기
        a = find(a);
        b = find(b);

        // 대표 노드 아니면 연결
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        else {
            // 중요!
            // value를 index로 바꿔서 찾고 대표 노드로 변경 (경로 압축)
            return parent[x] = find(parent[x]);
        }
    }

    private static boolean checkSame(int a, int b) {
        return find(a) == find(b);
    }
}