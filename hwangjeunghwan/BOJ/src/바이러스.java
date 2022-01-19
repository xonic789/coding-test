import java.util.Scanner;

public class 바이러스 {
static int count = 0;
static boolean visited[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		visited = new boolean[n+1];
		int[][] graph = new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		
		dfs(graph, n, 1);
		System.out.println(count-1);
		
	}
	static void dfs(int[][] graph, int n, int start) {
		visited[start] = true;
		count++;
		for(int i=1; i<=n; i++) {
			if(!visited[i] && graph[start][i]!=0)
				dfs(graph, n, i);
		}
	}
}
