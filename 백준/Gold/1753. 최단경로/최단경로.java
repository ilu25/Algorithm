import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int e;	// 목적지 정점 번호
	int w;	// 가중치
	
	public Node(int e, int w) {
		this.e = e;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node other) {
		return Integer.compare(this.w, other.w);
	}
}

public class Main {
	static int V, E;
	static List<Node>[] graph;
	static int[] path;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	
    	graph = new ArrayList[V + 1];
    	for (int i = 1; i <= V; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	
    	path = new int[V + 1];
    	Arrays.fill(path, Integer.MAX_VALUE);
    	    	    	
    	st = new StringTokenizer(br.readLine());
    	int s = Integer.parseInt(st.nextToken());
    	
    	// 그래프 저장
    	for (int i = 0; i < E; i++) {
    		st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		int weight = Integer.parseInt(st.nextToken());	
    		graph[start].add(new Node(end, weight));
    	}
    	
    	dijkstra(s);
    	
    	// 모든 정점들의 최단 경로
    	StringBuilder sb = new StringBuilder();
    	for (int i = 1; i <= V; i++) {
    		sb.append(path[i] == Integer.MAX_VALUE ? "INF" : path[i]).append('\n');
    	}
    	System.out.print(sb);
    }
    
    static void dijkstra(int s) {
    	PriorityQueue<Node> q = new PriorityQueue<>();
    	q.offer(new Node(s, 0));
    	path[s] = 0;
    	
    	while (!q.isEmpty()) {
    		Node cur = q.poll();
    		
    		// 기존 경로가 더 짧은 경우 패스
    		if (path[cur.e] < cur.w) {
    			continue;
    		}

    		for (Node next : graph[cur.e]) {
    			int w = path[cur.e] + next.w;
    			if (w < path[next.e]) {
    				path[next.e] = w;
    				q.offer(new Node(next.e, w));
    			}
    		}
    	}
    }
}

/* 
 * [문제]
 * - 방향 그래프, 간선 가중치 1 ~ 10
 * - 답: 시작점에서 다른 모든 정점으로의 최단 경로
 * - 정점 V개: 1 ~ 2만
 * - 간선 E개: 1 ~ 30만
 * 
 * [풀이]
 * - 모든 정점을 목적지로 BFS 돌리기
 * - 1시간 25분: 메모리 초과
 * - 20분: 기존 경로가 짧을 경우 다음 노드로 넘어가는 로직 추가 (시간 초과)
 * - 30분: 시작점 주어지고 다잌스트라 한 번만 돌리면 됨 (시간 초과)
 * -> 우선순위 큐 & 저장된 경로가 기존 경로보다 작은 경우 패스 (while 첫 if문) -> 중복 방문 제거!
*/
