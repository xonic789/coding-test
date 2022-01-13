package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int answer = 0;
    int cnt = 0;
    for (answer = 666; ; answer++) {
      boolean flag = false;
      int tmp = answer;
      while (tmp > 0) {
        if (tmp % 1000 == 666) {
          flag = true;
          break;
        }
        tmp /= 10;
      }

      if (flag) {
        cnt++;
        if (cnt == N) break;
      }

    }
    System.out.println(answer);
  }
}
