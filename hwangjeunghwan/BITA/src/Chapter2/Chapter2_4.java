package Chapter2;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chapter2_4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		int count = 0;
		while(!(input<=0)) {
			count +=  input /= 5;
			
			
		}
		System.out.println(count);
	}
}
