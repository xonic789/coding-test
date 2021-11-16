package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Goorm_동전줍기대회 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");
    // k번째 동전의 최대 값을 기록할 테이블
    long[] dp = new long[N];
    dp[0] = Integer.parseInt(input[0]);
    for (int i = 1; i < N; i++) {
      long coin = Long.parseLong(input[i]);
      dp[i] = Math.max(dp[i - 1] + coin, coin);
    }
    System.out.println(Arrays.stream(dp).max().getAsLong());
  }
}
