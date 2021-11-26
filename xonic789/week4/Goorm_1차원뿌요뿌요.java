package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Goorm_1차원뿌요뿌요 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    String str = br.readLine();
    // 터져야하는 위치를 담음.
    Stack<String> stack = new Stack<>();


    for (int i = 0; i < N; i++) {
      if (stack.isEmpty()) {
        stack.push(str.charAt(0) + " " + 1);
        continue;
      }
      if (stack.peek().charAt(0) == str.charAt(i)) {
        String[] peek = stack.peek().split(" ");
        char alpha = peek[0].charAt(0);
        int cnt = Integer.parseInt(peek[1]);
        stack.pop();
        stack.push(alpha + " " + (cnt + 1));
      } else {
        while (!stack.isEmpty()) {
          String[] peek = stack.peek().split(" ");
          int cnt = Integer.parseInt(peek[1]);
          if (cnt >= M) stack.pop();
          else break;
        }
        if (!stack.isEmpty() && stack.peek().charAt(0) == str.charAt(i)) {
          String[] peek = stack.peek().split(" ");
          char alpha = peek[0].charAt(0);
          int cnt = Integer.parseInt(peek[1]);
          stack.pop();
          stack.push(alpha + " " + (cnt + 1));
        } else stack.push(str.charAt(i) + " " + 1);
      }

    }
    if (stack.size() == 1){
      String[] s = stack.peek().split(" ");
      int cnt = Integer.parseInt(s[1]);
      if (cnt >= M) System.out.println("CLEAR!");
      else {
        System.out.print(String.valueOf(s[0]).repeat(Math.max(0, cnt)));
      }
    } else {
      for (String s : stack) {
        String[] s1 = s.split(" ");
        char alpha = s.charAt(0);
        int cnt = Integer.parseInt(s1[1]);
        if (cnt >= M) System.out.print(String.valueOf(s1[0]).repeat(Math.max(0, cnt)));
        else System.out.print(alpha);
      }
    }
  }
}
// ABEBADBDCDABABEAEDACABDC
// ABEBADBDCDABABEAEDACABDC