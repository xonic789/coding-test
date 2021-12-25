package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Location {
  private int x;
  private int y;

  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}


public class BOJ_1926_그림 {

  // 동남서북
  public static final int[] dx = {0, 1, 0, -1};
  public static final int[] dy = {1, 0, -1, 0};
  public static int n;
  public static int m;

  private static boolean[][] visit;


  /**
   * TODO
   *  색칠된 공간 맨 처음 발견 부분부터 BFS 수행.
   *  BFS 수행 중 방문처리 하고 그림 cnt++
   *  BFS 수행하며 넓이++해서 메서드 return해준다.
   *  max를 사용해서 max와 구한 넓이 중 큰 것을 max에 할당해준다.
   *
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);
    int[][] graph = new int[n][m];
    for (int i = 0; i < n; i++) {
      String[] tmp = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        graph[i][j] = tmp[j].charAt(0) - '0';
      }
    }
    visit = new boolean[n][m];
    int max = 0;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // 방문하지 않았고 색칠되어있다면 BFS
        if (!visit[i][j] && graph[i][j] == 1) {
          max = Math.max(BFS(graph, i, j), max);
          cnt++;
        }
      }
    }
    System.out.print(cnt + "\n" + max);
  }

  public static int BFS(int[][] graph, int a, int b) {
    int area = 1;
    Queue<Location> queue = new LinkedList<>();
    queue.offer(new Location(a, b));
    visit[a][b] = true;
    while (!queue.isEmpty()) {
      Location location = queue.poll();
      int x = location.getX();
      int y = location.getY();
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
        if (graph[nx][ny] == 1 && !visit[nx][ny]) {
          visit[nx][ny] = true;
          queue.offer(new Location(nx, ny));
          area++;
        }
      }
    }
    return area;
  }
}
