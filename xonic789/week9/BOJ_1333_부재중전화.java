package week9;

import java.util.Scanner;

public class BOJ_1333_부재중전화 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int L = sc.nextInt();
    int D = sc.nextInt();
    // 노래 재생
    int minute = 0;
    for (int i = 0; i < N; i++) {
      // 해당 노래만큼 재생
      // 1. 노래 시작 이후는 들을 수 없음
      // 2. 1초간 전화벨이 울림.
      minute += L;
      for (int j = 1; j <= 5; j++) {
        if (minute % D == 0) {
          System.out.println(minute);
          return;
        }
        minute++;
      }
    }
    // 끝나고 그 다음 D 의 배수에서 들을 수 있음
    // 끝나자마자 바로 들을 수 있다면, 현재 시간이 답
    // 하지만 끝나자마자 바로 들을 수 없다면 그 다음 전화벨이 울릴 시간을 구한다.
    // minute를 D로 나눠 몫을 구하고 그 몫에 +1을 해주면 지금까지 경과한 시간의 다음 D의 배수를 구함.
    System.out.println(minute % D == 0 ? minute : D * ((minute / D) + 1));
  }
}
