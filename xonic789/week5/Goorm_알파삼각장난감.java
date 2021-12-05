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
    List<Character> tree = new ArrayList<>();
    tree.add(null);

    for (int i = 1; i <= N; i++) {
      String line = br.readLine();
      for (int j = 0; j < line.length(); j++) {
        tree.add(line.charAt(j));
      }
    }
    DFS(tree, 1, 2, getCharNum(tree.get(1)), N);
    System.out.println(max);
  }

  public static void DFS(List<Character> tree, int node, int level, int sum, int N) {
    if (level > N) {
      max = Math.max(sum, max);
      return;
    }
    int lt = node + level - 1;
    int rt = node + level;

    DFS(tree, lt, level + 1, sum + getCharNum(tree.get(lt)), N);
    DFS(tree, rt, level + 1, sum + getCharNum(tree.get(rt)), N);
  }

  public static int getCharNum(char a) {
    return a - 64;
  }
}


// 1 2
// 2 3
// 3 4
// 4 5
/**
 *       1
 *      2 3
 *     4 5 6
 *    7 8 9 10
 * 11 12 13 14 15
 */