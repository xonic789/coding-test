package Chapter1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chapter1_10 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		long n = Long.parseLong(input[0]);
		long m = Long.parseLong(input[1]);
		
		long hover = (n/20)*(m/40);

		System.out.println(hover);
		long verho = (n/40)*(m/20);
		System.out.println(verho);
		long square = 2L*((n/40)*(m/40));
		System.out.println(square);
		

		System.out.println(hover+verho-square);
		
		
	}
}
