import java.io.*;
import java.util.*;

public class Main{
	
	static int map[][];
	static int dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();

		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		dp=new int[N+1][M+1];
		
		for(int i=0;i<N;i++) {
			String line[]=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i+1][j+1]=Integer.parseInt(line[j]);
			}
		}
	
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				dp[i][j]=Math.max(dp[i-1][j],Math.max(dp[i-1][j-1],dp[i][j-1]))+map[i][j];
			}
		}
		System.out.println(dp[N][M]);
	}
}