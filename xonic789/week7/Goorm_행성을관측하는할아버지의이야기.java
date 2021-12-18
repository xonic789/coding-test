package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Goorm_행성을관측하는할아버지의이야기 {

  private static int[][] graph;
  private static int[][] answer;
  private static boolean[] check;
  private static int smallCount;
  private static int largeCount;

  /**
   * TODO
   *  1. 첫번째 풀이
   *    - 행성을 기록할 2차원 배열을 두고,
   *    - 대소 입력이 온다면,
   *    - min, big을 두고 테이블에 기록한다. -> 작은거 큰거 2차원 배열 한다.
   *    -> 답이 아예 다름
   *  2. 두번째 풀이
   *    - 인접행렬으로 입력을 받고,
   *    - 행성이 작다면 그 행성보다 작은 모든 행성을 탐색해야됨.
   *    -  행성이 크다면 그 행성보다 큰 모든 행성 탐색.
   *    -> 시간초과..
   *
   *
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    // record
    graph = new int[N + 1][N + 1];
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
      graph[a][b] = 1;
      graph[b][a] = -1;
    }

    // 행성을 탐색하면서, 해당 행성보다 작은게 있다면 그 작은 행성에서
    for (int i = 1; i <= N; i++) {
      smallCount = 0;
      largeCount = 0;
      check = new boolean[N + 1];
      // 1번 행성부터 탐색
      // 이 행성보다 작은건 -1, 큰 건 +1이므로
      // 작다면 작은것만 찾고, 크면 큰 거만 찾아야됨.
      check[i] = true;
      for (int j = 1; j <= N; j++) {
        if (graph[i][j] != 0) {
          DFS(i, graph[i][j]);
        }
      }
      System.out.println(smallCount + " " + largeCount);
    }

  }

  private static void DFS(int a, int flag) {
    // 방문 기록
    check[a] = true;
    for (int i = 1; i < graph[a].length; i++) {
      // 방문하지 않은 행성이고,
      if (!check[i] && graph[a][i] == flag) {
        if (flag == 1) largeCount++;
        else smallCount++;
        DFS(i, flag);
      }
    }
  }
}
/*
4 4
1 3
2 3
4 2
4 3


*/