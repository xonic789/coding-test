package Chapter1;
import java.util.*;

class Charter1_1 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		char[] moum = {'a','e','i','o','u','A','E','I','O','U'};
		int n = sc.nextInt();
		String line;
		String answer = "";
		sc.nextLine();
		for(int i=0; i<n; i++){
			line = sc.nextLine();
			for(char a : line.toCharArray()){
				for(char b : moum){
					if(a == b){
						answer+= a;
					}
				}
			
			}
			if(answer.length()==0){
					answer+= "???";
				}
			System.out.print(answer);
			System.out.println();
			answer = "";
		}
		
	}
}