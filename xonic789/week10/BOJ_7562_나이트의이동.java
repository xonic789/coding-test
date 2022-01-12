package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {

  static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
  static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
  static int[][] tree;
  static boolean[][] visit;
  static Location dest;
  static int l;

  static class Location {
    int x;
    int y;

    Location(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Location location = (Location) o;
      return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      l = Integer.parseInt(br.readLine());
      tree = new int[l][l];
      visit = new boolean[l][l];
      StringTokenizer st = new StringTokenizer(br.readLine());
      // 시작점
      Queue<Location> queue = new LinkedList<>();
      queue.offer(new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      // 도착점
      st = new StringTokenizer(br.readLine());
      dest = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      System.out.println(BFS(queue));
    }
  }

  private static int BFS(Queue<Location> queue) {
    Location first = queue.peek();
    visit[first.x][first.y] = true;
    int level = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      while (qSize-- > 0) {
        Location poll = queue.poll();
        if (dest.equals(poll)) {
          return level;
        }
        for (int i = 0; i < 8; i++) {
          int nx = poll.x + dx[i];
          int ny = poll.y + dy[i];
          if (nx >= l || nx < 0 || ny >= l || ny < 0) continue;
          if (!visit[nx][ny]) {
            visit[nx][ny] = true;
            queue.offer(new Location(nx, ny));
          }
        }
      }
      level++;
    }
    return 0;
  }
}
