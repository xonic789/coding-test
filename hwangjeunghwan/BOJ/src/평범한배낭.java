import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Æò¹üÇÑ¹è³¶ {

	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int k=input.nextInt();
		int[] w=new int[n+1];
		int[] v=new int[n+1];
		for(int i=1;i<=n;i++){
			w[i]=input.nextInt();
			v[i]=input.nextInt();
		}
		
		int[][] dp=new int[n+1][k+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=k;j++){
				dp[i][j]=dp[i-1][j];
				if(j-w[i]>=0){
					dp[i][j]=Math.max(dp[i][j],  dp[i-1][j-w[i]]+v[i]);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
