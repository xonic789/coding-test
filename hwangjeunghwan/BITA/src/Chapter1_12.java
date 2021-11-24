import java.util.Arrays;
import java.util.Scanner;

public class Chapter1_12 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.nextLine();
		
		int[][] triangle = new int[n][n];
		int[][] dp = new int[n+1][n+1];
		
		
		for(int i=0; i<n; i++) {
			String alph = sc.nextLine();
			for(int j=0; j<alph.length(); j++) {
				triangle[i][j] = Integer.valueOf(alph.charAt(j)-64);
				}
		}
		
		for(int i=0; i<n; i++) {
			dp[0][i] = triangle[n-1][i];
		}
		
		/*
		  1
		  23
		  456
		  78910
		  1112131415
		
	0	  11 12 13 14  15                  
	1	    7  8  9  10
	2	      4  5  6            dp
	3	       2  3
	4	         1 


0         1
1       2  3
2      4  5  6             tri
3    7  8  9  10
4  11 12 13 14  15       
		  
		 
		 * */
		for(int i=1; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				dp[i][j] = Math.max(dp[i-1][j]+triangle[n-i-1][j], dp[i-1][j+1]+triangle[n-i-1][j]);
			
				}
		
		}
		
		
		System.out.println(dp[n-1][0]);
		
		
		
		
		
	}
}
