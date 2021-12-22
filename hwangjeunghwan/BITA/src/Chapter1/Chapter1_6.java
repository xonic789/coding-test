package Chapter1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Chapter1_6 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String coins[] = br.readLine().split(" ");
		Long n = Long.parseLong(input);
	
		long[] coin = new long[(int) (n+1)];
		long[] dp = new long[(int) (n+1)];
		int minuscount = 0;
		for(int i=1; i<=n; i++) {
			coin[i] = Integer.parseInt(coins[i-1]);
			if(coin[i] <0)
				minuscount++;
		}
		
		if(minuscount == n){
			System.out.print(0);
			return;
		}
		
		for(int i=1; i<=n; i++) {
			
			dp[i] = Math.max(dp[i-1]+coin[i], coin[i]);
		}
		
			Arrays.sort(dp);
			
				System.out.print(dp[dp.length-1]);
	}
}
