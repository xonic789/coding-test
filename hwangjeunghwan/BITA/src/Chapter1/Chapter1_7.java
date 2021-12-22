package Chapter1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Chapter1_7 {
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String nk[] = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		long[] coin = new long[n];
		long[] prefixSum = new long[n+1];
		String input[] = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
		
			
			if(input[i].charAt(0) == '-') {
				input[i] = input[i].substring(1, input[i].length());
				coin[i] = -1*(Integer.valueOf(input[i]));
			
			}
			else {
				input[i] = input[i].substring(1, input[i].length());
				coin[i] = Integer.valueOf(input[i]);
			
			}
		}
		for(int i=1; i<=n; i++) {
			prefixSum[i] = coin[i-1]+prefixSum[i-1];
		}
		
		
		int start;
		int end;
		long sum = 0;
		String plussum = "+";
		for(int i=0; i<k; i++) {
			String StartEnd[] = br.readLine().split(" ");
			
		
			sum = prefixSum[Integer.parseInt(StartEnd[1])]-prefixSum[Integer.parseInt(StartEnd[0])-1];
			
			
			if(sum >0) {
				plussum += String.valueOf(sum); 
				System.out.println(plussum);
				plussum = "+";
			}
			else {
				System.out.println(sum);	
			}
			
			sum = 0;
		}
		
		
	}
}
