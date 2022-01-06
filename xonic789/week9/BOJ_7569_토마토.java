package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7569_토마토 {

  static int[][][] tree;
  // 동남서북
  static final int[] dx = {0, 1, 0, -1};
  static final int[] dy = {1, 0, -1, 0};
  static final int[] dz = {-1, 1};
  static boolean[][][] visit;
  static int numberOfAllTomato;
  static int N;
  static int M;
  static int H;
  static Queue<Location> queue = new LinkedList<>();
  static int ripeTomatoes;

  static class Location {
    int x;
    int y;
    int z;

    Location(int z, int x, int y) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }


  // TODO
  //  처음에 토마토 총 갯수를 세서 저장해둔다.
  //  Queue에 익은 토마토가 들어가있을테니까, 사이즈를 세고 큐에 넣을 때 마다 cnt++
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    M = Integer.parseInt(input[0]);
    N = Integer.parseInt(input[1]);
    H = Integer.parseInt(input[2]);

    tree = new int[H][N][M];
    visit = new boolean[H][N][M];

    numberOfAllTomato = 0;
    ripeTomatoes = 0;
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        String[] line = br.readLine().split(" ");
        for (int k = 0; k < M; k++) {
          int e = Integer.parseInt(line[k]);
          if (e != 0) tree[i][j][k] = e;
          if (e != -1) numberOfAllTomato++;
          if (e == 1) {
            ripeTomatoes++;
            queue.offer(new Location(i, j, k));
            visit[i][j][k] = true;
          }

        }
      }
    }

    if (numberOfAllTomato == ripeTomatoes) {
      System.out.println(0);
      return;
    }

    System.out.println(BFS());
  }

  private static int BFS() {
    int answer = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      if (ripeTomatoes == numberOfAllTomato) return answer;
      while (qSize-- > 0) {
        Location poll = queue.poll();
        for (int i = 0; i < 4; i++) {
          int nx = poll.x + dx[i];
          int ny = poll.y + dy[i];
          if (nx >= N || nx < 0 || ny >= M || ny < 0) continue;
          if (!visit[poll.z][nx][ny] && tree[poll.z][nx][ny] == 0) {
            ripeTomatoes++;
            visit[poll.z][nx][ny] = true;
            queue.offer(new Location(poll.z, nx, ny));
          }
        }
        for (int i = 0; i < 2; i++) {
          int nz = poll.z + dz[i];
          if (nz >= H || nz < 0) continue;
          if (!visit[nz][poll.x][poll.y] && tree[nz][poll.x][poll.y] == 0) {
            ripeTomatoes++;
            visit[nz][poll.x][poll.y] = true;
            queue.offer(new Location(nz, poll.x, poll.y));
          }
        }
      }
      answer++;
    }

    return -1;
  }
}
