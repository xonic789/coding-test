package week3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Goorm_외계인과용돈기입장 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int M = Integer.parseInt(input[1]);
    String[] history = br.readLine().split(" ");
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < M; i++) {
      String[] s = br.readLine().split(" ");
      int start = Integer.parseInt(s[0]) - 1, end = Integer.parseInt(s[1]);
      int sum = 0;
      for (int j = start; j < end; j++) {
        char sign = history[j].charAt(0);
        if (sign == '+') {
          sum += Integer.parseInt(history[j].substring(1));
        } else {
          sum -= Integer.parseInt(history[j].substring(1));
        }
      }
      bw.write(sum > 0 ? "+" + sum : String.valueOf(sum));
    }
    bw.flush();
  }
}
