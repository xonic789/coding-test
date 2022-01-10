import java.util.Scanner;

public class 신기한소수 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		dfs("",n,0);
		System.out.println(sb);
	}
	public static void dfs(String s, int n, int count) {
		if(count == n) {
			sb.append(s+"\n");
			return;
		}
		for(int i=1; i<=9; i++) {
			if(isPrime(Integer.parseInt(s+i))) {
				dfs(s+i, n, count+1);
			}
		}
	}
	public static boolean isPrime(int num) {
		if(num == 1)return false;
		
		int sqrt = (int)Math.sqrt(num);
		for(int i=2; i<=sqrt; i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
}
