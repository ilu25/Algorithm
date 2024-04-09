import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static int[][] board;
	public static int MINUS = 0;
	public static int ZERO = 0;
	public static int PLUS = 0;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		StringTokenizer st;
 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		partition(0, 0, N);
 
		System.out.println(MINUS);
		System.out.println(ZERO);
		System.out.println(PLUS);
 
	}
 
	public static void partition(int row, int col, int size) {
		
		if (colorCheck(row, col, size)) {
			// 영역이 같은 색이면 1 증가
			if(board[row][col] == -1) { 
				MINUS++;
			}
			else if(board[row][col] == 0) {
				ZERO++;
			}
			else {
				PLUS++;
			}
			return;
		}
		
		// 3x3 영역으로 분할 -> 추후 영역에 다른 색이 있으면 분할
		int newSize = size / 3;
		
		for (int i = row; i < row + size; i += newSize) {
			for (int j = col; j < col + size; j += newSize) {
				partition(i, j, newSize);
			}
		}
 
	}
 
	// 해당 영역이 같은 색인지 검사하는 메소드
	public static boolean colorCheck(int row, int col, int size) {
		int color = board[row][col];
 
		// 각 블럭의 시작점(row, col)부터 블럭의 끝(row + size, col + size)까지 검사
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
 
}