import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ≈‰∏∂≈‰ {
private static int N;
private static int M;
private static int H;
static int[][][] graph;
static boolean[][][] visited;
static int[] dx = {-1, 0, 1, 0, 0, 0};
static int[] dy = {0, 1, 0, -1, 0, 0};
static int[] dz = {0, 0, 0, 0, -1, 1};
static class Tomato {
	int x;
	int y;
	int z;
	Tomato(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

}
static Queue<Tomato> q = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		graph = new int[H][N][M];
		visited = new boolean[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					graph[i][j][k] = sc.nextInt();
					if(graph[i][j][k]==1) {
						visited[i][j][k] =true;
						q.add(new Tomato(i, j, k));
					}
				}
			}
		}
		
		
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		
		while(!q.isEmpty()) {
			
			Tomato curr = q.poll();
			
			for(int i=0; i<6; i++) {
				int nx = dx[i] + curr.x;
				int ny = dy[i] + curr.y;
				int nz = dz[i] + curr.z;
				if(nx>=0&&ny>=0&&nz>=0&&nx<H&&ny<N&&nz<M) {
				if(graph[nx][ny][nz] == 0) {
				q.add(new Tomato(nx,ny,nz));
				graph[nx][ny][nz] = graph[curr.x][curr.y][curr.z] +1;
				}
				}
		}
		}
			int result = Integer.MIN_VALUE;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						if(graph[i][j][k]==0) {
							return -1;
						}
						result = Math.max(result, graph[i][j][k]);
					}
				}
			}
			if(result==1) return 0;
			else return (result - 1);

		
	}
}
