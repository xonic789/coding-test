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
    String str = br.readLine() + "0";
    // 터져야하는 위치를 담음.
    Stack<String> stack = new Stack<>();


    for (int i = 0; i < N + 1; i++) {
      // 비어있으면 무조건 넣음.
      if (stack.isEmpty()) {
        stack.push(str.charAt(i) + " " + 1);
        continue;
      }
      if (stack.peek().charAt(0) == str.charAt(i)) {
        String[] peek = stack.peek().split(" ");
        char alpha = peek[0].charAt(0);
        int cnt = Integer.parseInt(peek[1]);
        stack.pop();
        stack.push(alpha + " " + (cnt + 1));
      } else {
        String[] peek = stack.peek().split(" ");
        char alpha = peek[0].charAt(0);
        int cnt = Integer.parseInt(peek[1]);
        if (cnt >= M) {
          stack.pop();
          i--;
        } else {
          stack.push(str.charAt(i) + " " + 1);
        }
      }

    }
    //
    stack.pop();

    if (stack.isEmpty()) {
      System.out.println("CLEAR!");
      return;
    }

    for (String s : stack) {
      String[] s1 = s.split(" ");
      System.out.print(String.valueOf(s1[0]).repeat(Math.max(0, Integer.parseInt(s1[1]))));
    }
  }
}
