package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Goorm_알파벳트리장난감 {
  public static List<Integer> answer = new ArrayList<>();
  public static int min = Integer.MAX_VALUE;
  public static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Character> tree = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String alpha = br.readLine();
      for (int j = 0; j < alpha.length(); j++) {
        tree.add(alpha.charAt(j));
      }
    }
    DFS(tree, 0, getNum(tree.get(0)));
    System.out.print(min + "\n" + max);
  }

  public static void DFS(List<Character> tree, int node, int sum) {
    int lt = 2 * node + 1;
    int rt = 2 * node + 2;
    // 포화 이진트리이기 때문에, 자식 노드가 존재하지 않으면 (왼쪽 자식 노드만 확인하면 된다, 왼쪽 자식노드가 트리의 사이즈보다 크거나 같다면)
    if (lt >= tree.size()) {
      if (max < sum) max = sum;
      if (min > sum) min = sum;
      return;
    }
    DFS(tree, lt, sum + getNum(tree.get(lt)));
    DFS(tree, rt, sum + getNum(tree.get(rt)));
  }


  public static int getNum(Character c) {
    return c - 64;
  }
}