package week3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Goorm_외계인과용돈기입장 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
    String[] history = br.readLine().split(" ");
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    long[] sums = new long[N + 1];
    int sum = 0;
    for (int i = 1; i <= N; i++) {
      char sign = history[i - 1].charAt(0);
      if (sign == '+') {
        sum += Integer.parseInt(history[i - 1].substring(1));
      } else {
        sum -= Integer.parseInt(history[i - 1].substring(1));
      }
      sums[i] = sum;
    }

    for (int i = 0; i < M; i++) {
      String[] s = br.readLine().split(" ");
      int start = Integer.parseInt(s[0]), end = Integer.parseInt(s[1]);
      long answer = sums[end] - sums[start - 1];
      bw.write(answer > 0 ? "+" + answer : String.valueOf(answer));
      bw.write("\n");
    }
    bw.flush();
  }
}
