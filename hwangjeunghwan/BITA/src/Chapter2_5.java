import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Chapter2_5 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		long n= sc.nextLong();
		long m= sc.nextLong();
		
		int[] paper = new int[(int) n];
		
		for(int i=0; i<n; i++)
			paper[i] = sc.nextInt();
		
		Arrays.sort(paper);
		int i = paper[paper.length-1];
		int result = -1;
		
			long sum = 0;
			for(int j=0; j<paper.length; j++) {
				sum += (i-paper[j]);
			}
			
		if(sum>m) {
			System.out.println("No way!");
			
		}	
		else if(sum==m) {
			System.out.println(i);
			
		}
		else {
		result = (int) (i+ (m-sum)/n);	
		
		System.out.println(result);
		}
	}
	
	
}
