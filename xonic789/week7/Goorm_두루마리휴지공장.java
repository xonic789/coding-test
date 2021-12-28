package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Goorm_두루마리휴지공장 {


  /**
   * TODO
   *  1. 첫번째 풀이
   *    - 이진탐색으로 푼다.
   *    - lt는 휴지의 max값
   *    - rt는 M 최대 범위보다 크게 둬야한다..
   *    - mid = (lt+rt) /2
   *    - 사용 가능한 휴지 길이로 더해보고 -가 나오면 바로 리턴
   *    -
   *
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    int[] arr = new int[N];
    int sum = 0;
    int max = Integer.MIN_VALUE;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum += arr[i];
      max = Math.max(arr[i], max);
    }

    if ((long)N * max - sum > M) {
      System.out.println("No way!");
      return;
    }

    System.out.println(binarySearch(arr, N, M));
  }

  public static int binarySearch(int[] arr, int N, int M) {

    int lt = Arrays.stream(arr).max().getAsInt();
    int rt = 2000000000;

    while (lt <= rt) {
      // 중간 값을 각 배열에 넣어봄.
      int mid = rt - (rt - lt) / 2;
      // 사용한 티슈가 남았을 때는 lt를 늘려줌
      long usedTissue = 0;

      for (int i = 0; i < N; i++) {
        usedTissue += mid - arr[i];
      }
      // 쓴 휴지가 M보다 크다면 탐색 범위를 좁힘
      if (usedTissue > M) rt = mid - 1;
      else lt = mid + 1;
    }
    return rt;
  }
}
