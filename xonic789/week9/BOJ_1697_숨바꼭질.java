package week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697_숨바꼭질 {

  /*
  * TODO
  *   1. 첫번째 풀이
  *     수빈이 위치에서 X-1, X+1, X*2를 모두 해준다.
  *     모두 해주고 큐에 넣고 동생 위치라면 바로 출력하고 리턴한다.
  *     음수이거나, 동생의 위치를 벗어나면 큐에 넣지 않는다.
  *     수빈이 위치가 동생 위치보다 더 앞에 있을 수 있으므로 크기를 100001로 초기화한다.
  *     
  * */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] dist = new int[100001];
    for (int i = 0; i < 100001; i++) {
      dist[i] = -1;
    }
    dist[N] = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(N);
    while (dist[K] == -1) {
      int e = queue.poll();
      for (int nxt : new int[]{e - 1, e + 1, e * 2}) {
        if (nxt < 0 || nxt > 100000) continue;
        if (dist[nxt] != -1) continue;
        dist[nxt] = dist[e] + 1;
        queue.offer(nxt);
      }
    }
    System.out.println(dist[K]);
  }
}
