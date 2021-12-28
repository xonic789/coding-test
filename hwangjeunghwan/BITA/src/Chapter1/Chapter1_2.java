package Chapter1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Chapter1_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		
		long n = Long.parseLong(input[0]);
		long m = Long.parseLong(input[1]);
		
		
		long answer = 0;
		
		if(n==m) {
			answer = longanswer(n);
			
		}
		else {
			answer = 2L;
		}
		
		System.out.print(answer);
	}
	
	public static long longanswer(long n) {
		for(Long i=2L; i*i<=n; i++) {
			if(n % i == 0) {
				return i;
			}
		}
		return n;
	}
}