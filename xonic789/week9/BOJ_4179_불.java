package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Location_4179 {
  int x;
  int y;

  public Location_4179(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class BOJ_4179_불 {

  // 동남서북
  public static final int[] dx = {0, 1, 0, -1};
  public static final int[] dy = {1, 0, -1, 0};


  /*
    Todo
      1. 첫번째 풀이
        - J와 F를 큐에 넣고 BFS 돌며 J는 불이 번지지 않은 곳으로만 간다.
        - F는 방문체크를 하며 계속해서 불을 번지게 만듬.
        - J가 사방을 돌았을 때 좌표가 R과 C를 비교해서 배열의 길이 내에 분포되지 않으면 answer + 1로 리턴한다.
        -> 메모리초과
      2. BFS를 두번돈다..
  */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int R = Integer.parseInt(input[0]);
    int C = Integer.parseInt(input[1]);
    char[][] maze = new char[R][C];
    int[][] dist1 = new int[R][C];
    int[][] dist2 = new int[R][C];
    Queue<Location_4179> fQueue = new LinkedList<>();
    Queue<Location_4179> jQueue = new LinkedList<>();
    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        maze[i][j] = line.charAt(j);
        dist1[i][j] = -1;
        dist2[i][j] = -1;
        if (maze[i][j] == 'F') {
          fQueue.offer(new Location_4179(i, j));
          dist1[i][j] = 0;
        } else if (maze[i][j] == 'J'){
          jQueue.offer(new Location_4179(i, j));
          dist2[i][j] = 0;
        }
      }
    }


    while (!fQueue.isEmpty()) {
      Location_4179 poll = fQueue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = poll.x + dx[i];
        int ny = poll.y + dy[i];
        if (nx >= R || ny >= C || nx < 0 || ny < 0) continue;
        if (dist1[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
        dist1[nx][ny] = dist1[poll.x][poll.y] + 1;
        fQueue.offer(new Location_4179(nx, ny));
      }
    }

    while (!jQueue.isEmpty()) {
      Location_4179 poll = jQueue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = poll.x + dx[i];
        int ny = poll.y + dy[i];
        if (nx >= R || ny >= C || nx < 0 || ny < 0) {
          System.out.println(dist2[poll.x][poll.y] + 1);
          return;
        }
        if (dist2[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
        if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[poll.x][poll.y] + 1) continue;
        dist2[nx][ny] = dist2[poll.x][poll.y] + 1;
        jQueue.offer(new Location_4179(nx, ny));
      }
    }


    System.out.println("IMPOSSIBLE");
  }
}