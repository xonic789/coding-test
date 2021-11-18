import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Chapter1_8 {
	
	static int N;
	static int M;
	static char[][] board;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int count = -1;
	static Queue<Point> q = new LinkedList<>();
	static class Point{
		int x; int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;

		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N= sc.nextInt(); M= sc.nextInt();
		board = new char[N][M];
		visited = new boolean[N][M];
		String line;
		int wonjunX = 0;
		int wonjunY = 0;
		int fireX = 0;
		int fireY = 0;
		sc.nextLine();
		int k = 0;
		for(int i=0; i<N; i++) {
			line = sc.nextLine();
			int j=0;
			for(char a : line.toCharArray()) {
				board[i][j] = a;
				if(a == '@') {
					fireX = i;
					fireY = j;
					q.add(new Point(fireX, fireY));
					visited[fireX][fireY] = true;
					k++;
				}
				if(a == '&') {
					wonjunX = i;
					wonjunY = j;
				}
				j++;
 			}
		}
			bfs(wonjunX, wonjunY);
		System.out.println(count);
		
	}
	
	static void bfs(int wonjunX, int wonjunY) {
		

		
		int ans = 0;
		while(!q.isEmpty()) {
			int qs = q.size();
			for(int i=0; i<qs; i++) {
				Point curr = q.poll();
				
				if(curr.x == wonjunX&&curr.y == wonjunY) {
					if(count == -1) {
						count = ans-1;	
					}
					
				}
				
				for(int j=0; j<4; j++) {
					int nx = curr.x + dx[j]; int ny = curr.y + dy[j];
					if(nx>N-1||nx<0||ny>M-1||ny<0) continue;
					if(visited[nx][ny]) continue;
					if(board[nx][ny] == '#') continue;
					
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}	
			}	
			ans++;
		}
	}
}
