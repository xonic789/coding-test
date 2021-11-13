package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Goorm_교수님의과제폭탄 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer[]> inputs = new ArrayList<>();
    // 입력을 받아서 리스트에 저장
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      String[] start = input[0].split("/");
      String[] end = input[1].split("/");
      int s = Integer.parseInt(start[0]) * 100 + Integer.parseInt(start[1]);
      int e = Integer.parseInt(end[0]) * 100 + Integer.parseInt(end[1]);
      Integer[] tmp = new Integer[2];
      tmp[0] = s;
      tmp[1] = e;
      inputs.add(tmp);
    }

    // 시작일이 빠른 순서대로 정렬,
    // 시작일이 같을 시 마감일이 늦은 걸 먼저 선택하기 때문에,
    // 시작일이 같을 시 마감일이 더 늦은 순으로 정렬한다.
    inputs.sort((a, b) -> {
      if (a[0].equals(b[0])) {
        return b[1].compareTo(a[1]);
      }
      return a[0].compareTo(b[0]);
    });

    List<Integer[]> homeworks = new ArrayList<>();
    int index = 1;

    // 과제 일자를 과제 종류와 함께 리스트에 담는다.
    for (Integer[] dates : inputs) {
      Integer[] start = new Integer[2];
      start[0] = dates[0];
      start[1] = index;
      homeworks.add(start);
      Integer[] end = new Integer[2];
      end[0] = dates[1];
      end[1] = -(index++);
      homeworks.add(end);
    }

    // 과제 일자를 기준으로 오름차순 정렬하며,
    // 시작일자는 앞으로 오고, 마감일자는 자연스레 뒤로간다.
    // 시작일자가 같을 시 과제의 종류를 기준으로 내림차순 정렬한다.
    homeworks.sort((a, b) -> {
      if (a[0].equals(b[0])) {
        return a[1].compareTo(b[1]);
      }
      return a[0].compareTo(b[0]);
    });

    Stack<Integer[]> stack = new Stack<>();
    stack.push(homeworks.get(0));

    // 과제 종류가 양수일 경우에는 스택에 넣는다.
    for (int i = 1; i < homeworks.size(); i++) {
      Integer[] homework = homeworks.get(i);
      if (homework[1] > 0) {
        stack.push(homework);
      // 음수일 경우에는 과제의 절댓값을 비교하여 같은 과제의 종류이면 스택에서 빼준다.
      } else {
        if (stack.isEmpty()) break;
        Integer[] previous = stack.peek();
        if (Math.abs(previous[1]) == Math.abs(homework[1])) {
          stack.pop();
        } else break;
      }
    }

    // 스택이 비어있지 않다면 마무리 못한 과제가 남아 있다는 뜻이기 때문에 No 출력.
    if (!stack.isEmpty()) System.out.println("No");
    else System.out.println("Yes");
  }
}
