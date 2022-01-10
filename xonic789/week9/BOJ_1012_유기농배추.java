package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {

  static class Location {
    int x;
    int y;

    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }


  // 동남서북
  public static final int[] dx = {0, 1, 0, -1};
  public static final int[] dy = {1, 0, -1, 0};
  public static int[][] tree;
  public static boolean[][] visit;
  public static int n;
  public static int m;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      tree = new int[n][m];
      // 배추 채우기
      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());
        tree[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
      }
      // 배추 영역 개수 체크 BFS
      visit = new boolean[n][m];
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        for (int l = 0; l < m; l++) {
          if (!visit[j][l] && tree[j][l] == 1) {
            BFS(j, l);
            cnt++;
          }
        }
      }
      System.out.println(cnt);
    }

  }

  private static void BFS(int x, int y) {
    Queue<Location> queue = new LinkedList<>();
    queue.offer(new Location(x, y));
    visit[x][y] = true;

    while (!queue.isEmpty()) {
      Location poll = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = poll.x + dx[i];
        int ny = poll.y + dy[i];
        if (nx >= n || nx < 0 || ny >= m || ny < 0) continue;
        if (!visit[nx][ny] && tree[nx][ny] == 1) {
          visit[nx][ny] = true;
          queue.offer(new Location(nx, ny));
        }
      }
    }
  }
}
