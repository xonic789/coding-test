package Chapter1;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Chapter1_11 {
	static class block{
		char block;
		int count;
		block(char block, int count){
			this.block = block;
			this.count = count;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int k = sc.nextInt();
		sc.nextLine();
		String BBuyo = sc.nextLine();
		List<block> s = new LinkedList<>();

		BBuyo += "&";
		for(int i=0; i<BBuyo.length(); i++) {
			
			if(s.isEmpty()) {
				s.add(new block(BBuyo.charAt(i), 1));
			}
			else if(s.get(s.size()-1).block == BBuyo.charAt(i)) {
				s.get(s.size()-1).count++;
			}
			else {
				if(s.get(s.size()-1).count >= k) {
					s.remove(s.size()-1); 
					i--;
				}
				else {
					s.add(new block(BBuyo.charAt(i), 1));
				}
			}
		}
		
		s.remove(s.size()-1);
	 
		if(s.size() == 0) {
			System.out.println("CLEAR!");
			return;
		}
		else {
			for(int i=0; i<s.size(); i++) {
				System.out.print(s.get(i).block);
			}
				
		}
	
		
}
	
}
