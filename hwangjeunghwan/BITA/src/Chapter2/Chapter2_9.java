package Chapter2;

import java.util.Scanner;

public class Chapter2_9 {
	static int dp[][] = new int[11][1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		
		int result = minTrial(n, k/10);
		System.out.println(result);
	}

	static int minTrial(int n, int k) {
		// 기저사례: n이 1일 때와 k가 0, 1일 때
	    if (n == 1) return k;
	    if (k <= 1) return k;

	    int ret = dp[n][k];
	    if (ret != -1) return ret;

	    // 절대 나올 수 없는 큰 값으로 초기화
	    ret = 987654321;
	    for (int x = 1; x <= k; ++x)
	        ret = Math.min(ret, 1 + Math.max(minTrial(n - 1, x - 1), minTrial(n, k - x)));

	    return ret;
	}
}
