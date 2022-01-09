package week10;

public class PRO_없는숫자더하기 {
  public int solution(int[] numbers) {
    int answer = 0;
    int N = numbers.length;
    boolean[] check = new boolean[10];
    for (int i = 0; i < N; i++) {
      check[numbers[i]] = true;
    }

    for (int i = 0; i < 10; i++) {
      if (!check[i]) answer += i;
    }
    return answer;
  }
  public static void main(String[] args) {

  }
}
