package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Goorm_불이야 {
  public static int[] dx = {0, 0, 1, -1};
  public static int[] dy = {1, -1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    int R = Integer.parseInt(input[0]), C = Integer.parseInt(input[1]);
    char[][] lab = new char[R][C];

    Queue<List<Integer>> queue = new LinkedList<>();
    int[] wonjunLocation = new int[2];
    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        char ch = line.charAt(j);
        if (ch == '@') {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          list.add(j);
          queue.offer(list);
        }
//        원준이를 동서남북으로 돌려서 막혀있다면 바로 -1 리턴
        if (ch == '&') {
          wonjunLocation[0] = i;
          wonjunLocation[1] = j;
        }
        lab[i][j] = ch;
      }
    }
    int answer = BFS(lab, queue, wonjunLocation);
    System.out.println(answer);
  }

  private static int BFS(char[][] lab, Queue<List<Integer>> queue, int[] wonjun) {
    // 동서남북

    int[][] graph = new int[lab.length][lab[0].length];
    while (!queue.isEmpty()) {
      List<Integer> location = queue.poll();
      int x = location.get(0), y = location.get(1);
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx >= lab.length || ny >= lab[0].length) {
          continue;
        }
        if (lab[nx][ny] == '.') {
          lab[nx][ny] = '@';
          graph[nx][ny] = graph[x][y] + 1;
          List<Integer> dLocation = new ArrayList<>();
          dLocation.add(nx);
          dLocation.add(ny);
          queue.offer(dLocation);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < 4; i++) {
      int nx = wonjun[0] + dx[i];
      int ny = wonjun[1] + dy[i];
      if (nx < 0 || ny < 0 || nx >= lab.length || ny >= lab[0].length) {
        continue;
      }
      int s = graph[nx][ny];
      if (min > s && lab[nx][ny] == '@') {
        min = s;
      }
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
