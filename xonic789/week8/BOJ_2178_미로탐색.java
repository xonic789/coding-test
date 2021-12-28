package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Location_2178 {
  private int x;
  private int y;

  public Location_2178(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
}

public class BOJ_2178_미로탐색 {

  // 동남서북
  public static final int[] dx = {0, 1, 0, -1};
  public static final int[] dy = {1, 0, -1, 0};


  /* TODO
      일반 BFS 사용.
      방문 배열을 두고 중복 방분하지 않는다.
      맨 처음 0,0부터 BFS를 도는데, 해당 좌표를 방문처리하고
      1이면 방문 처리 후 좌표를 큐에 넣으면서 BFS 진행
  */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    String[] graph = new String[n];
    for (int i = 0; i < n; i++) {
      graph[i] = br.readLine();
    }
    int answer = 1;
    boolean[][] visit = new boolean[n][m];
    Queue<Location_2178> queue = new LinkedList<>();
    queue.offer(new Location_2178(0, 0));
    visit[0][0] = true;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      while (qSize-- > 0) {
        Location_2178 location = queue.poll();
        int x = location.getX();
        int y = location.getY();
        if (x == n - 1 && y == m - 1) {
          System.out.println(answer);
          return;
        }
        for (int i = 0; i < 4; i++) {
          int nx = x + dx[i];
          int ny = y + dy[i];
          if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
          if (!visit[nx][ny] && graph[nx].charAt(ny) == '1') {
            visit[nx][ny] = true;
            queue.offer(new Location_2178(nx, ny));
          }
        }
      }
      answer++;
    }
    System.out.println(-1);
  }
}
