package Chapter2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Chapter2_6 {
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0, -1,0,1};
 	
	static class Point{
		int x;
		int y;
		int mp;
		int dist;
		Point(int x, int y, int mp,int dist){
			this.x = x;
			this.y = y;
			this.mp = mp;
			this.dist = dist;
		}
	}
	static int forest[][];
	static boolean[][][] visited = new boolean[100][100][11];
	static int count = -1;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); int m = sc.nextInt(); int mp = sc.nextInt();
		
		forest = new int[n][m];
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			String s = sc.nextLine();
			for(int j=0; j<s.length(); j++) {
				forest[i][j] = Integer.valueOf(s.charAt(j)-48);
			}
		}
		
		bfs(n, m , mp);
		System.out.println(count);
	
		
	}
	
	static void bfs(int n, int m, int mp) {
		
		Queue<Point> q= new LinkedList<>();
		q.add(new Point(0,0,mp/10,0));
		visited[0][0][mp/10] = true;
		int ans = 0;
		while(!(q.isEmpty())) {
			
			
				Point curr = q.poll();

				if(curr.x == n-1&& curr.y == m-1) {
					if(count == -1) {
						count = curr.dist;
					}
					else {
						count = Math.min(count, curr.dist);
					}
				}
				
				for(int i=0; i<4; i++) {
					int nx = curr.x + dx[i]; int ny = curr.y + dy[i];
					if(nx<0||nx>n-1||ny<0||ny>m-1) continue;
					if(visited[nx][ny][curr.mp])continue;
					
					if(forest[nx][ny] == 0) {
						visited[nx][ny][curr.mp] = true;
						q.add(new Point(nx, ny, curr.mp,curr.dist+1));
					}
					else if(curr.mp>0) {
						int nnx = nx + dx[i];
						int nny = ny + dy[i];
						if(nnx<0||nnx>n-1||nny<0||nny>m-1) continue;
						if(visited[nnx][nny][curr.mp-1])continue;
						
						if(forest[nnx][nny] == 0) {
							visited[nnx][nny][curr.mp-1] = true;
							q.add(new Point(nnx, nny, curr.mp-1,curr.dist+1));

						}
					}
			}
				
		
			
		}
		
		
	}
	
}
