package Chapter2;
import java.util.Scanner;
public class Chapter2_8 {
	
final static long P = 1000000007;	

static long C(long n, long r) {
	long a = 1L, b = 1L;

    // a = n! / (n-r)!
    // b = r!
    for (int i = 0; i < r; ++i) {
        a = a * (n - i) % P;
        b = b * (i + 1) % P;
    }

    // nCr = a / b = a * b^-1
    return a * pow(b, P - 2) % P;
}

public static long pow(long base, long expo) {
	
	// 지수가 1일 경우 base^1 이므로 base % P를 리턴
	if(expo == 1) {
		return base % P;
	}
	// 지수의 절반에 해당하는 base^(expo / 2) 을 구한다.
	long temp = pow(base, expo / 2);
	
	/*
	 * 현재 지수가 홀 수 였다면
	 * base^(expo / 2) * base^(expo / 2) * base 이므로
	 * base를 한 번 더 곱해주어야 한다.
	 * 
	 * ex) A^9 = A^4 * A^4 * A
	 */
	if(expo % 2 == 1) {
		return (temp * temp % P) * base % P;
	}
	return temp * temp % P;
			
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
	        a -= C(x2 + y2, x2) * C(x1 - x2 + y1 - y2, x1 - x2) % P;

	    // 도토리 -> 최종위치에 함정이 있는 경우
	    if (x1 <= x2 && y1 <= y2)
	        b -= C(x2 - x1 + y2 - y1, x2 - x1) * C(N - x2 + M - y2, N - x2) % P;

	    // 음수가 됐다면 양수로 만들어 준다
	    if (a < 0) a += P;
	    if (b < 0) b += P;

	    

	    System.out.println(a*b%P);
		
		
	}
}
