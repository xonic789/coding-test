package exam;

import java.util.*;
class 완전제곱수 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for(int i=0; i<n; i++){
			int m = sc.nextInt();
			int k = (int)Math.sqrt(m);
		
			double t = Math.sqrt(m);
		
			if(k*k == (int)(t*t)){
				count++;
			}
		}
		System.out.println(count);
	}
}