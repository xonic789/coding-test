import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 단지번호붙이기 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int count = 0;
	static int aparts[] = new int[25*25];
	static List<Integer> housecount = new ArrayList<>();
	static boolean visited[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] apt = new int[n][n];
		visited = new boolean[n][n];
		String line;
		sc.nextLine();
		for(int i=0; i<n; i++) {
			line = sc.nextLine();
			for(int j=0; j<line.length(); j++) {
				apt[i][j] = line.charAt(j)-'0';
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(apt[i][j]== 1&& !visited[i][j]) {
					count++;
					dfs(apt, n, i, j);
				}
					
			}
		}
		System.out.println(count);
		 Arrays.sort(aparts);
	        for(int i=0; i<aparts.length; i++){
	            if(aparts[i] == 0){
	            }else{               
	                System.out.println(aparts[i]);
	            }
	        }
		
	}
	static void dfs(int[][] apt, int n, int x, int y) {
		visited[x][y] = true;
		aparts[count]++;
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(apt[nx][ny]==1&&!visited[nx][ny]) {
					dfs(apt, n, nx, ny);
					
				}
			}
		}
		
	}
}
