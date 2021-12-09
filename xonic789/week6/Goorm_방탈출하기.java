package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Goorm_방탈출하기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    StringBuilder answer = new StringBuilder();
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      answer.append(binarySearch(arr, Integer.parseInt(st.nextToken())));
      answer.append("\n");
    }

    System.out.print(answer);
  }

  private static int binarySearch(int[] arr, int target) {
    int lt = 0;
    int rt = arr.length - 1;

    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (arr[mid] == target) return 1;
      if (arr[mid] < target) {
        lt = mid + 1;
      } else {
        rt = mid - 1;
      }
    }
    return 0;
  }
}
