package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Goorm_숫자블럭쌓기 {

  public static final String REMOVE = "remove";

  /**
   * TODO
   *  1. 첫번째 풀이
   *    - add는 스택에 넣는다.
   *    - remove는 버킷에 쌓는다
   *    - remove시 버킷.peek해서 버킷의 맨 위 숫자 == peek + 1이라면 맨위 빼서 버킷에 넣음
   *    - 아니라면 answer++ 후 스택의 숫자를 remove한다.
   *    -> 정렬 매 번 해줘야해서 비효율적. (타임 아웃)
   *  2. 두번째 풀이
   *    - x라는 변수를 두고, 현재 쌓아야할 블럭을 기록함.
   *    - 만약 remove시 맨 위 e가 쌓아야할 블럭이 아니라면 스택을 모두 비우고 answer++
   *    - remove 블럭에 들어갈 때마다 e++
   *    - e는 말 그대로 리무브 횟수이기 때문에,
   *    - add 다음 remove가 온다는게 보장되어있으므로 가능한 로직.
   *
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    int e = 1;
    boolean isSorted = false;
    for (int i = 0; i < N * 2; i++) {
      String method = br.readLine();
      if (!method.equals(REMOVE)) {
        String[] arr = method.split(" ");
        stack.push(Integer.parseInt(arr[1]));
      } else {
        // 버킷에 담아야할 요소가 스택의 맨 마지막에 들어간 요소와 같을 때
        if (!stack.isEmpty() && e == stack.peek()) {
          stack.pop();
        // 맨 마지막에 들어간 요소가 아니고, 스택이 비지 않았을 때
        } else if (!stack.isEmpty()) {
          // 스택을 비워준다.
          while (!stack.isEmpty()) {
            stack.pop();
          }
          answer++;
        }
        e++;
      }
    }
    System.out.println(answer);
  }
}
/**
 *
 */