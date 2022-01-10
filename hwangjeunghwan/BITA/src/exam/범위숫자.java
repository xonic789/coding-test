package exam;

import java.util.Scanner;

public class 범위숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int first;
		int middle;
		int last;
		int sum = 0;
		for(int i=n; i<=m; i++) {
			if(i>=10&&i<100) {
				last = i%10;
				first = (i-last)/10;
				sum += last*first;
				
			}
			else if(i>=100&&i<1000){
				last = i%100%10;
				middle = (i%100-last)/10;
				first = (i-middle-last)/100;
				sum += last*first*middle;
			}
			else {
				
			}
		}
		System.out.println(sum);
	}

}
