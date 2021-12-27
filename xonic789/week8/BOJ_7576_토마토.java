package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location_7576 {
  int x;
  int y;

  Location_7576(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class BOJ_7576_토마토 {

  // 동서남북
  public static final int[] dx = {0, 0, 1, -1};
  public static final int[] dy = {1, -1, 0, 0};
  public static int tomatoCnt;
  public static int N;
  public static int M;
  public static int[][] graph;
  /* TODO
      예외 : 처음부터 모두 익었으면 0
              모두 익을 수 없다면 -1
      1. 첫번째 풀이
        1만 찾아서 BFS 돌리고, -1을 제외한 카운트를 입력 받을 때 받고,
        BFS가 모든 토마토를 익히고 리턴됐을때 해당 토마토와 같다면 min = Math.min()로 변수를 할당한다.
        -> 시간초과
      2. 처음부터 토마토가 익은 좌표를 큐에 넣어줌.
      -> BFS 한 번만 돌리면 된다.



   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    M = Integer.parseInt(input[0]);
    N = Integer.parseInt(input[1]);
    graph = new int[N][M];
    tomatoCnt = 0;
    int ripeTomatoCnt = 0;
    Queue<Location_7576> queue = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        if (graph[i][j] != -1) tomatoCnt++;
        if (graph[i][j] == 1) {
          queue.offer(new Location_7576(i, j));
          ripeTomatoCnt++;
        }
      }
    }
    // 이미 모든 토마토가 익음.
    if (tomatoCnt == ripeTomatoCnt) {
      System.out.println(0);
      return;
    }


    System.out.println(BFS(queue));
  }

  private static int BFS(Queue<Location_7576> queue) {
    int level = 0;
    boolean[][] visit = new boolean[N][M];
    int cnt = queue.size();
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      while (qSize-- > 0) {
        Location_7576 location = queue.poll();
        for (int i = 0; i < 4; i++) {
          int nx = location.x + dx[i];
          int ny = location.y + dy[i];
          if (nx >= N || ny >= M || nx < 0 || ny < 0) continue;
          // 토마토이고 방문하지 않았으면 큐에 넣는다.
          if (graph[nx][ny] == 0 && !visit[nx][ny]) {
            queue.offer(new Location_7576(nx, ny));
            visit[nx][ny] = true;
            cnt++;
          }
        }
      }
      level++;
    }

    return tomatoCnt == cnt ? level - 1: -1;
  }

}
