import java.util.*;
class Chapter1_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		int answer=0;
		if(n==m) {
			int[] count = new int[m +1];
			
			for(int i=2; i*i<m; i++) {
				if(m % i == 0) {
					count[i]++;
				}
			}
			int k = count[0];
			for(int i=0; i<count.length; i++) {
				if(k<count[i]) {
					k = count[i];
					answer = i;
				}
			}
		}
		else {
			answer = 2;
		}
		
		System.out.print(answer);
	}
}