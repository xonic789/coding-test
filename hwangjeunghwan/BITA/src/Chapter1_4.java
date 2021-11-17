import java.io.*;
class Chapter1_4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String s = "";
		int count = 0;

			if(input.contains("12")){
				input = input.replaceFirst("12","");
				count++;
				if(input.contains("21")){
				input = input.replaceFirst("21","");
				count++;
			}
		}
			
	
		
		if(count >= 2){
			System.out.print("Yes");
		}
		else{
			System.out.print("No");
		}
		
	}
}