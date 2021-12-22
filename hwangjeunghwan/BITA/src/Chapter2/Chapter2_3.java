package Chapter2;
import java.util.Scanner;

public class Chapter2_3 {
	
	static int INF = 1000000;
	static int[][] d = new int[201][201];
	
	public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt(); //행성의 개수
	int m = sc.nextInt(); //대소 비교에 관한 정보의 개수
	
	for(int i=0; i<m; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		d[a][b] = 1; // a가 b보다 작다
		d[b][a] = -1; // b가 a보다 작다
	}
	
	for(int k=1; k<=n; k++) {
		//i = 출발 노드
		for(int i=1; i<=n; i++) {
			//j=도착노드
			for(int j=1; j<=n; j++) {
				if(d[i][k]==1&&d[k][j]==1)
					d[i][j] = 1;
			}
		}
	}
				
	for(int i=1; i<=n; i++) {
		int large =0; int small =0;
		for(int j=1; j<=n; j++) {if(i != j) {
			if(d[i][j]==1) ++small;
			if(d[j][i]==1) ++large;}
		}
		System.out.println(large + " "+small);
	}

	
	
	}
	
	static void floydWashall(int n) {

		//k= 거쳐가는 노드
		for(int k=1; k<=n; k++) {
			//i = 출발 노드
			for(int i=1; i<=n; i++) {
				//j=도착노드
				for(int j=1; j<=n; j++) {
					if(d[i][k]+d[k][j] < d[i][j])
						d[i][j] = d[i][k] + d[k][j];
				}
			}
		}
	}
}
