package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Goorm_알파벳트리장난감 {
  public static List<Integer> answer = new ArrayList<>();

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
    System.out.println(answer.stream().min(Integer::compareTo).get());
    System.out.println(answer.stream().max(Integer::compareTo).get());
  }

  public static void DFS(List<Character> tree, int node, int sum) {
    int lt = 2 * node + 1;
    int rt = 2 * node + 2;
    if (lt >= tree.size()) {
      answer.add(sum);
      return;
    }
    int lv = getNum(tree.get(lt));
    int rv = getNum(tree.get(rt));
    DFS(tree, lt, sum + lv);
    DFS(tree, rt, sum + rv);
  }


  public static int getNum(Character c) {
    return c - 64;
  }
}
