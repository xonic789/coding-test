package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {

  static int N;
  static String tree[];
  static int M;
  static boolean[][] visit;
  static final int[] dx = {0, 1, 0, -1};
  static final int[] dy = {1, 0, -1, 0};


  static class Location {
    char ch;
    int x;
    int y;

    Location(char ch, int x, int y) {
      this.ch = ch;
      this.x = x;
      this.y = y;
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    tree = new String[N];
    for (int i = 0; i < N; i++) {
      tree[i] = br.readLine();
    }
    M = tree[0].length();


    int cnt = 0;
    visit = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visit[i][j]) {
          BFS(i, j);
          cnt++;
        }
      }
    }
    System.out.print(cnt + " ");
    visit = new boolean[N][M];
    cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visit[i][j]) {
          colorWeaknessBFS(i, j);
          cnt++;
        }
      }
    }

    System.out.print(cnt);
  }

  private static void BFS(int x, int y) {
    Queue<Location> queue = new LinkedList<>();
    queue.offer(new Location(tree[x].charAt(y), x, y));
    visit[x][y] = true;
    while (!queue.isEmpty()) {
      Location lo = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = lo.x + dx[i];
        int ny = lo.y + dy[i];
        if (nx >= N || nx < 0 || ny >= M || ny < 0) continue;
        if (!visit[nx][ny] && tree[nx].charAt(ny) == lo.ch) {
          visit[nx][ny] = true;
          queue.offer(new Location(tree[nx].charAt(ny), nx, ny));
        }
      }
    }
  }

  private static void colorWeaknessBFS(int x, int y) {
    Queue<Location> queue = new LinkedList<>();
    queue.offer(new Location(tree[x].charAt(y), x, y));
    visit[x][y] = true;
    while (!queue.isEmpty()) {
      Location lo = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = lo.x + dx[i];
        int ny = lo.y + dy[i];
        if (nx >= N || nx < 0 || ny >= M || ny < 0) continue;
        if (tree[nx].charAt(ny) == 'G' || tree[nx].charAt(ny) == 'R') {
          if (!visit[nx][ny] && (lo.ch == 'G' || lo.ch == 'R')) {
            visit[nx][ny] = true;
            queue.offer(new Location(tree[nx].charAt(ny), nx, ny));
          }
        } else if (!visit[nx][ny] && tree[nx].charAt(ny) == lo.ch) {
          visit[nx][ny] = true;
          queue.offer(new Location(tree[nx].charAt(ny), nx, ny));
        }
      }
    }
  }
}
