import java.util.*;
import java.util.Scanner;

public class 백조의호수 {

	
	
	static char[][] Lake;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt(); 
		int C = sc.nextInt();
		
		String[] water = new String[R];
		int start = 0, start2 = 0;
		int end = 0, end2 = 0;
		boolean flag = false;
		sc.nextLine();
		for(int i=0; i<R; i++) {
				water[i] = sc.next();	
		}
		
		
		Lake = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				Lake[i][j] = water[i].charAt(j);
				if(water[i].charAt(j) =='L'&&flag==false) {
					start=i; start2=j;
					flag = true;
				}
				if(water[i].charAt(j) =='L'&&flag==true) {
					end=i; end2=j;
				}
			}
		}
		int count=0;
	//	while(!bfs(Lake, start, start2, end, end2)) {
		for(int i=0; i<R; i++) {
			
			for(int j=0; j<C; j++) {
				if(Lake[i][j]=='.'&&visited[i][j]==false) {
					dfs(Lake, visited, i, j);	
					count++;
				}
			}
		}
		for(int k=0; k<R; k++) {
			for(int t=0; t<C; t++) {
				System.out.print(Lake[k][t]);
			}
			System.out.println();
		}
		
			

	//	}
		
		System.out.println(count);
		
	}
	
	
	static void dfs(char[][] Lake, boolean[][] visited, int i, int j) {
		
		visited[i][j] = true;
		
		for(int k=0; k<4; k++) {
			int nx = i+dx[k]; int ny = j+dy[k];
			if(nx<0||ny<0||nx>Lake.length-1||ny>Lake[0].length-1) continue;
			if(visited[nx][ny]) continue;
			if(Lake[nx][ny] == 'X') {
				Lake[nx][ny] = '.';
				visited[nx][ny] = true;
			}
		}
		
		
	}
	
	static boolean bfs(char[][] Lake, int start, int start2, int end, int end2) {
		boolean[][] visited2 = new boolean[Lake.length][Lake[0].length];
		
		Queue<point> q = new LinkedList<>();
		visited2[start][start2] = true;
		q.offer(new point(start, start2));
		
		while(q.isEmpty()) {
		
			point curr = q.poll();
			if(curr.x == end && curr.y == end2) return true;
			
			
			for(int i=0; i<4; i++) {
				int nx = curr.x+dx[i]; int ny=curr.y+dy[i];
				if(nx<0||ny<0||nx>Lake.length-1||ny>Lake[0].length-1) continue;
				if(visited2[nx][ny]) continue;
				if(Lake[nx][ny]=='X')continue;			
				visited2[nx][ny] = true;
				q.add(new point(nx, ny));
			}
			
		}
		return false;
	}
	static class point{
		int x;
		
		int y;
		public point(int x, int y) {
			x = x;
			y = y;
		}
		
	}
}
