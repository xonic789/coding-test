import java.util.Scanner;

public class ÃÌ¼ö°è»ê {
static int[][] graph;
static boolean visited[];
static int hcount = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		int x = sc.nextInt(); int y = sc.nextInt();
		
		int k = sc.nextInt();
		for(int i=0; i<k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		dfs(x, y, n, 0);
		System.out.println(hcount);
	}
	
	static void dfs(int x, int y, int n, int count) {
		visited[x] = true;
		if(x == y) {
			hcount = count;
		}
		for(int i=1; i<=n; i++) {
			if(!visited[i]&&graph[x][i]==1) {
				dfs(i, y, n, count+1);
			}
		}
	}
}
