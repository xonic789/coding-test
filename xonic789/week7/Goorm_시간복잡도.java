package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goorm_시간복잡도 {

  /**
   * N이 10억까지 들어오기 때문에 일일이 O(n!) 연산을 수행한다는 것은 말도 안되는 짓
   * 수학적 관점에서 해당 수에 10을 곱하면 뒤에 0이 붙기 때문에
   * 10을 소인수분해 해주면 2 * 5이고, 2의 개수는 5의 개수보다 항상 많으니 5의 개수만 세면 된다.
   * N이 0이 될 때까지 N을 5로 나눠 cnt라는 변수에 저장하면 0의 갯수가 나온다.
   *
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int cnt = 0;
    while (N != 0) {
      cnt += N /= 5;
    }

    System.out.println(cnt);
  }
}
