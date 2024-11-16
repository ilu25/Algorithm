import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] check; // 집합 0, 1
    static boolean[] visited;
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;

            // 에지 데이터 저장
            for (int j = 1; j <= V; j++) {
                A[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS 실행
            for (int j = 1; j <= V; j++) {
                if (isEven) {
                    DFS(j);
                }
                else {
                    break;
                }
            }

            if (isEven) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int v) {
        visited[v] = true;

        // 인접 리스트로 받아서 v와 연결된 모든 노드 탐색
        for (int i : A[v]) {
            if (!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류
                check[i] = (check[v] + 1) % 2;  // 0 또는 1
                DFS(i);
            }
            else if (check[v] == check[i]) {
                isEven = false;
            }
        }
    }
}