package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Magician {
  private final int x;
  private final int y;
  private final int k;
  private boolean[][] visits;

  public Magician(int x, int y, int k, boolean[][] visit) {
    this.x = x;
    this.y = y;
    this.k = k;
    this.visits = visit;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getK() {
    return k;
  }

  public void setVisits(boolean[][] visits) {
    this.visits = visits;
  }

  public boolean[][] getVisits() {
    return visits;
  }

}


public class Goorm_초급마법사의시험 {

  private static int[][] graph;
  // 남북동서
  private static final int[] dx = {1, -1, 0, 0};
  private static final int[] dy = {0, 0, 1, -1};

  /**
   * TODO
   *  1. 첫번째 풀이
   *    - BFS 사용해서 0이면 내가 지나온 거리 +1을 해서 출구는 R - 1, C - 1 지점만 찾아주면 됨
   *    - 클래스 매지션을 통해서 x,y,k를 기록하고 그에 따른 반복문을 돌지만,
   *    - 해당 매지션의 방문 기록을 남겨야하기 때문에 실패.. (배열의 깊은복사가 계속 일어나야함)
   *
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    // 세로
    int R = Integer.parseInt(input[0]);
    // 가로
    int C = Integer.parseInt(input[1]);
    // 마력
    int K = Integer.parseInt(input[2]);
    // 1. boolean 배열을 둬서 true -> 나무 없음 false -> 나무
    // 해당 위치에 있는 마법사가 true이면 큐가 가지고 있는
    graph = new int[R][C];
    int[][] magicianRoute = new int[R][C];
    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        graph[i][j] = str.charAt(j) - '0' == 0 ? 0 : -1;
      }
    }
    int answer = 1;
    Queue<Magician> queue = new LinkedList<>();
    queue.offer(new Magician(0, 0, K, new boolean[R][C]));
    while (!queue.isEmpty()) {
      int qSize = queue.size();
      while (qSize-- != 0 && qSize >= 0) {
        if (graph[R - 1][C - 1] != 0) {
          System.out.println(graph[R - 1][C - 1]);
          return;
        }
        // 큐에서 매지션 꺼내서
        Magician magician = queue.poll();
        int magicianX = magician.getX();
        int magicianY = magician.getY();
        int magicianK = magician.getK();
        boolean[][] visits = magician.getVisits();
        for (int i = 0; i < 4; i++) {
          int nx = magicianX + dx[i];
          int ny = magicianY + dy[i];
          int k = magicianK;
          if (nx >= R || ny >= C || nx < 0 || ny < 0) {
            continue;
          }
          // 만약 나무라면 마력이 있으면 더블점프, 없으면
          if (graph[nx][ny] == -1) {
            if (magicianK - 10 < 0) continue;
            nx += dx[i];
            ny += dy[i];
            if (nx >= R || ny >= C || nx < 0 || ny < 0) {
              continue;
            }
            if (graph[nx][ny] == -1) continue;
            k -= 10;
          }
          if (!visits[nx][ny]) {
            visits[nx][ny] = true;
            boolean[][] tmp = new boolean[R][C];
            for (int j = 0; j < R; j++) {
              for (int l = 0; l < C; l++) {
                tmp[j][l] = visits[j][l];
              }
            }
            queue.offer(new Magician(nx, ny, k, tmp));
            graph[nx][ny] = answer;
          }
        }
      }
      answer++;
    }
  }
}

