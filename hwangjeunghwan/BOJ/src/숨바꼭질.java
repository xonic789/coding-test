import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ¼û¹Ù²ÀÁú {
static int visited[] = new int[100001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); int k = sc.nextInt();
		
		dfs(n, k, 0);
		
		System.out.println(visited[k]);
		
	}
	static void dfs(int n, int k, int count) {
		visited[n] = 0;
		Queue<Integer> q= new LinkedList<>();
		q.add(n);
		
		while(!q.isEmpty()) {
			
			int curr = q.poll();
			
			
			if(curr == k) break;
			if(curr>0 && visited[curr-1] ==0) {
				q.add(curr-1);
				visited[curr-1] = visited[curr] +1;
			}
			if(curr <100000&&visited[curr+1]==0) {
				q.add(curr+1);
				visited[curr+1] = visited[curr]+1;
			}
			if(curr *2<=100000&&visited[curr*2]==0) {
				q.add(curr*2);
				visited[curr*2] = visited[curr]+1;
			}
		}
	
	}
}
