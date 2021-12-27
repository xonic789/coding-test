package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Goorm_알파삼각장난감 {

  public static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(Integer.parseInt(br.readLine()) - 64);
      return;
    }
    List<List<Character>> tree = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      List<Character> node = new ArrayList<>();
      for (int j = 0; j < line.length(); j++) {
        node.add(line.charAt(j));
      }
      tree.add(node);
    }

    // 동적 테이블.
    int[][] dp = new int[2001][2001];
    // 레벨 1의 루트 노드 dp에 넣고 시작
    dp[0][0] = getCharNum(tree.get(0).get(0));

    for (int i = 1; i < N; i++) {
      List<Character> node = tree.get(i);
      for (int j = 0; j < node.size(); j++) {
        // 해당 i 단계의 가장 왼쪽 노드는 전 단계의 가장 왼쪽 노드에서 내려옴.
        // 그러므로 그 노드의 최댓값을 더 해주고 테이블에 기록
        if (j == 0) {
          dp[i][j] = getCharNum(node.get(j)) + dp[i - 1][j];
        // 가장 오른 쪽 노드는 전 단계의 가장 오른쪽 노드에서 내려옴
          // 그러므로 그 노드의 최댓값을 더 해주고 테이블에 기록
        } else if (j == node.size() - 1) {
          dp[i][j] = getCharNum(node.get(j)) + dp[i - 1][j - 1];
        // 가장 오른쪽, 가장 왼쪽을 제외하면 해당 노드는 왼쪽, 오른쪽 노드에서 내려오므로 왼쪽, 오른쪽 노드에서의 최대값과 현재 노드 값을 더 해주고
        // 테이블에 기록한다.
        } else {
          dp[i][j] = getCharNum(node.get(j)) + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
        }
        max = Math.max(dp[i][j], max);
      }
    }
    System.out.println(max);
  }


  public static int getCharNum(char a) {
    return a - 64;
  }
}

