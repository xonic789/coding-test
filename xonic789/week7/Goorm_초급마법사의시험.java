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

  public Magician(int x, int y, int k) {
    this.x = x;
    this.y = y;
    this.k = k;
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

}



public class Goorm_초급마법사의시험 {

  private static String[] graph;
  // 동서남북
  private static final int[] dx = {0, 0, 1, -1};
  private static final int[] dy = {1, -1, 0, 0};
  private static boolean[][][] visits;
  private static int R,C;

  /**
   * TODO
   *  1. 첫번째 풀이
   *    - BFS 사용해서 0이면 내가 지나온 거리 +1을 해서 출구는 R - 1, C - 1 지점만 찾아주면 됨
   *    - 클래스 매지션을 통해서 x,y,k를 기록하고 그에 따른 반복문을 돌지만,
   *    - 해당 매지션의 방문 기록을 남겨야하기 때문에 실패.. (배열의 깊은복사가 계속 일어나야함)
   *  2. 두번째 풀이(비타알고 참고)
   *    - 단계만큼만 BFS 진행하며 3차원 방문 배열을 둔다.
   *    K(마력)은 1 <= 100이니 100까지 둬도 되지만 마력 소모량이 10으로 고정되어 있으므로 K/10 -> 3차원 배열은 [R][C][K / 10 + 1]로 초기화 해준다.
   *    3차원 배열을 선언하면 마력 소모량에 따른 좌표를 따로 방문 체크를 할 수 있다
   *    ex) [0][1][1], [0][1][0] 식으로 방문 체크 가능
   *    왜냐하면 마력 소모에 따른 위치 체크를 해야 마력 소모해서 가는게 최선인지, 소모하지 않고 가는게 최선인지 알 수 있기 때문.
   *    어차피 단계에 따른 이동 시간은 answer로 기록을 하기 때문에 가능한 풀이이다.
   *
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    // 세로
    R = Integer.parseInt(input[0]);
    // 가로
    C = Integer.parseInt(input[1]);
    // 마력
    int K = Integer.parseInt(input[2]);
    graph = new String[R];
    for (int i = 0; i < R; i++) {
      graph[i] = br.readLine();
    }
    visits = new boolean[R][C][K / 10 + 1];
    Queue<Magician> queue = new LinkedList<>();
    queue.offer(new Magician(0, 0, K / 10));
    visits[0][0][K / 10] = true;
    int answer = 0;
    while (!queue.isEmpty()) {
      int qSize = queue.size();

      // 딱 현재 단계만큼만 BFS 진행
      while (qSize-- > 0) {
        Magician magician = queue.poll();
        int x = magician.getX();
        int y = magician.getY();
        int k = magician.getK();

        // 매지션의 좌표가 마지막 좌표와 같다면 현재 매지션의 위치는 출구임. 그러므로 바로 종료
        if (x == R - 1 && y == C - 1) {
          System.out.println(answer);
          return;
        }

        // 4방향을 탐색한다.
        for (int i = 0; i < 4; i++) {
          int nx = x + dx[i];
          int ny = y + dy[i];

          // 배열의 범위를 벗어나거나 방문했다면 이동 불필요함.
          if (isArrayIndexOutOfBounds(nx, ny) || visits[nx][ny][k]) continue;

          // 나무가 없다면 이동
          if (graph[nx].charAt(ny) == '0') {
            visits[nx][ny][k] = true;
            queue.offer(new Magician(nx, ny, k));
          // 나무가 있고, 마법을 사용할 수 있으면
          } else if (k > 0) {
            nx += dx[i];
            ny += dy[i];
            // 마법을 사용했기 때문에 이미 마법을 사용 했을 경우
            // k - 1, 즉 마법을 사용한 3차원 배열의 좌표가 이미 방문 했을 경우 더 이상 보지 않아도 됨.
            if (isArrayIndexOutOfBounds(nx, ny) || visits[nx][ny][k - 1]) continue;
            // 다음 칸이 나무가 아니라면
            if (graph[nx].charAt(ny) == '0') {
              visits[nx][ny][k - 1] = true;
              queue.offer(new Magician(nx, ny, k - 1));
            }
          }
        }
      }
      // 그래프의 단계를 모두 탐색했으므로 단계 증가
      answer++;
    }

    System.out.println(-1);
  }

  public static boolean isArrayIndexOutOfBounds(int nx, int ny) {
    return nx >= R || ny >= C || nx < 0 || ny < 0;
  }
}

