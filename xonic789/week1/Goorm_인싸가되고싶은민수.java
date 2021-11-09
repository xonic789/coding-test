package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goorm_인싸가되고싶은민수 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 두 가지 경우
    // 1. a == b
    // 2. a != b
    String[] input = br.readLine().split(" ");
    long a = Long.parseLong(input[0]);
    long b = Long.parseLong(input[1]);
    long minimumDivisor = 0;
    if (a != b) {
      minimumDivisor = 2L;
    } else {
      minimumDivisor = getMinimumDivisor(a);
    }

    System.out.println(minimumDivisor);
  }

  public static long getMinimumDivisor(long a) {
    //
    for (long i = 2L; i * i <= a; i++) {
      // 나누어 떨어질 때
      if (a % i == 0) {
        return i;
      }
    }
    return a;
  }
}
