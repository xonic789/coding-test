package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_5427_불 {

  // 동남서북
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static char[][] tree;
  static int[][] dist1;
  static int[][] dist2;
  static int n;
  static int m;

  static class Location {
    int x;
    int y;

    Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String[] xy = br.readLine().split(" ");
      int m = Integer.parseInt(xy[0]);
      int n = Integer.parseInt(xy[1]);
      Queue<Location> fQueue = new LinkedList<>();
      Queue<Location> sQueue = new LinkedList<>();

      tree = new char[n][m];
      dist1 = new int[n][m];
      dist2 = new int[n][m];
      // 입력받기
      for (int j = 0; j < n; j++) {
        String line = br.readLine();
        for (int k = 0; k < m; k++) {
          char ch = line.charAt(k);
          tree[j][k] = ch;
          dist1[j][k] = -1;
          dist2[j][k] = -1;
          // 불
          if (ch == '*') {
            fQueue.offer(new Location(j, k));
            dist1[j][k] = 0;
          }
          if (ch == '@') {
            sQueue.offer(new Location(j, k));
            dist2[j][k] = 0;
          }
        }
      }

      while (!fQueue.isEmpty()) {
        Location poll = fQueue.poll();
        for (int j = 0; j < 4; j++) {
          int nx = poll.x + dx[j];
          int ny = poll.y + dy[j];
          if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
          // 벽이거나, 이미 방문(-1)했으면 continue
          if (tree[nx][ny] == '#' || dist1[nx][ny] >= 0) continue;
          dist1[nx][ny] = dist1[poll.x][poll.y] + 1;
          fQueue.offer(new Location(nx, ny));
        }
      }

      boolean flag = false;
      while (!sQueue.isEmpty()) {
        Location poll = sQueue.poll();
        for (int j = 0; j < 4; j++) {
          int nx = poll.x + dx[j];
          int ny = poll.y + dy[j];
          if (nx >= n || ny >= m || nx < 0 || ny < 0) {
            if (dist2[poll.x][poll.y] != -1) {
              System.out.println(dist2[poll.x][poll.y] + 1);
              flag = true;
              break;
            }
            continue;
          }
          // 벽이거나, 이미 방문(!= -1)했으면 continue
          if (tree[nx][ny] == '#' || dist2[nx][ny] >= 0) continue;
          if (dist1[nx][ny] != -1 && dist2[poll.x][poll.y] + 1 >= dist1[nx][ny]) continue;
          dist2[nx][ny] = dist2[poll.x][poll.y] + 1;
          sQueue.offer(new Location(nx, ny));
        }
        if (flag) break;
      }
      if (!flag) System.out.println("IMPOSSIBLE");
    }
  }
}
/*
1
7 4
###.###
#....*#
#@....#
.######



*/