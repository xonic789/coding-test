import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ¹Ì·ÎÅ½»ö {
static int[][] maze;
static int[] dx = {-1,0,1,0};
static int[] dy = {0, -1,0,1};
static int count = -1;
static class Point{
	int x; int y; int dist;
	Point(int x, int y, int dist){
		this.x=x;
		this.y=y;
		this.dist=dist;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int m = sc.nextInt();
		maze = new int[n][m];
		sc.nextLine();
		for(int i=0; i<n; i++) {
			String temp = sc.nextLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = Integer.valueOf(temp.charAt(j)-48);
			}
		}
		
		bfs(maze, n, m);
		System.out.println(count);
	}
	
	static void bfs(int[][] maze, int n, int m) {
		boolean visited[][] = new boolean[n][m];
		
		Queue<Point> q= new LinkedList<Point>();
		q.add(new Point(0,0,1));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Point curr = q.poll();
			
			if(curr.x == n-1 && curr.y== m-1) {
				if(count == -1) {
					count = curr.dist;
				}
				else {
					count = Math.min(count, curr.dist);
				}
				
			}
			
			for(int i=0; i<4; i++) {
				int nx = curr.x+dx[i];
				int ny = curr.y+dy[i];
				
				if(nx<0||nx>n-1||ny<0||ny>m-1) continue;
				if(visited[nx][ny]) continue;
				if(maze[nx][ny]==0) continue;
				visited[nx][ny] = true;
				q.add(new Point(nx,ny,curr.dist+1));
			}
		}
		
	}
}
