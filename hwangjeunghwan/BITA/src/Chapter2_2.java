import java.util.Scanner;
import java.util.Stack;

public class Chapter2_2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
	/*	Stack<String> s = new Stack<>();
		int n = sc.nextInt();
		sc.nextLine();
		int k = 1;
		int answer = 0;
		boolean flag = true;
		for(int i=0; i<n*2; i++) {
			String block = sc.nextLine();
			if(block.equals("remove")) {

				if(!s.empty()&&s.peek().substring(4, s.peek().length()).equals(String.valueOf(k))) {
					
						s.pop();
						k++;
					
						
				}else {
					if(flag) {
						//System.out.println(s.peek());
						answer++;
						//System.out.println(answer);
					}
						flag = false;
						s.pop();
						k++;		
				}
			
			}
			else {
				s.add(block);
				flag = true;
			}
			
		}
		
		System.out.println(answer);*/
		
		
		int n = sc.nextInt();
		
		int now = 1; 
		int result = 0;
		
		Stack<Integer> s = new Stack<>();
		sc.nextLine();
		for(int x, i=0; i<2*n; i++) {
			String block = sc.next();
			if(block.equals("add")) {
				x = sc.nextInt();
				s.push(x);
			}
			else {
				if(!s.empty()&&s.peek() == now) {
					s.pop();
				}
				else if(!s.empty()) {
					result++;
					while(!s.empty())s.pop();
				}
				now++;
			}
		}
		
		for(int i : s) {
		//	System.out.println(i );
		}
		System.out.println(result);
	}
}
