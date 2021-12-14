package Chapter2;

import java.util.Scanner;

//해설지를 이해하지 못 하겠습니다.
public class Chapter2_8 {
	
final static int MOD = 1000000007;	

static long C(int n, int r) {
	long a = 1, b = 1;

    // a = n! / (n-r)!
    // b = r!
    for (int i = 0; i < r; ++i) {
        a = a * (n - i) % MOD;
        b = b * (i + 1) % MOD;
    }

    // nCr = a / b = a * b^-1
    return a * fpow(b, MOD - 2) % MOD;
}

static long fpow(long b, int n) {
	long ret = 1;
	// n을 이진수로 생각하여 해당 비트에 대응되는 a^(2^k)을 곱한다
    while (n>0) {
        if ((n&1)==0) {
        	ret = ret * b % MOD;
        	}
        b =  b * b % MOD;
        n >>= 1;
    }
    return ret;
}
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		 // 시작위치 -> 도토리
	    long a = C(x1 + y1, x1);
	    // 도토리 -> 최종위치
	    long b = C(N - x1 + M - y1, N - x1);

	    // 시작위치 -> 도토리에 함정이 있는 경우
	    if (x2 <= x1 && y2 <= y1)
	        a -= C(x2 + y2, x2) * C(x1 - x2 + y1 - y2, x1 - x2) % MOD;

	    // 도토리 -> 최종위치에 함정이 있는 경우
	    if (x1 <= x2 && y1 <= y2)
	        b -= C(x2 - x1 + y2 - y1, x2 - x1) * C(N - x2 + M - y2, N - x2) % MOD;

	    // 음수가 됐다면 양수로 만들어 준다
	    if (a < 0) a += MOD;
	    if (b < 0) b += MOD;

	    

	    System.out.println(a*b%MOD);
		
		
	}
}
