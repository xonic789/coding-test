package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goorm_인싸가되고싶은민수 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 세가지 경우
    // 1. a == b
    // 2. a != b
    String[] input = br.readLine().split(" ");
    long a = Integer.parseInt(input[0]);
    long b = Integer.parseInt(input[1]);
    long minimumDivisor = 0;
    if (a == b) {
      minimumDivisor = getMinimumDivisor(a);
    }
    if (a != b) {
      long length = Math.abs(a - b);
      if (length > 2) {
        minimumDivisor = 2L;
      } else {
        if (a == 1) {
          minimumDivisor = getMinimumDivisor(b);
        } else if (b == 1) {
          minimumDivisor = getMinimumDivisor(a);
        } else {
          minimumDivisor = Math.min(getMinimumDivisor(a), getMinimumDivisor(b));
        }
      }
    }
    System.out.println(minimumDivisor);
  }

  public static long getMinimumDivisor(long a) {
    for (int i = 2; i <= Math.sqrt(a); i++) {
      // 나누어 떨어질 때
      if (a % i == 0) {
        return i;
      }
    }
    return a;
  }
}
