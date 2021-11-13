package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goorm_1등과2등 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int l = input.indexOf("12");
    StringBuilder sb = new StringBuilder();
    if (l != -1) {
      for (int i = 0; i < input.length(); i++) {
        if (i != l && i != l + 1) {
          sb.append(input.charAt(i));
        }
      }
    }
    String answer = sb.toString().contains("21") ? "Yes" : "No";

    System.out.println(answer);

  }
}
