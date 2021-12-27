package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 기하학... 신발끈 공식
public class Goorm_여름의대삼각형 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] coordinates = new int[3][2];
    for (int i = 0; i < 3; i++) {
      String[] coordinate = br.readLine().split(" ");
      coordinates[i][0] = Integer.parseInt(coordinate[0]);
      coordinates[i][1] = Integer.parseInt(coordinate[1]);
    }

    double abs = Math.abs(
            (coordinates[0][0] * coordinates[1][1] + coordinates[1][0] * coordinates[2][1] + coordinates[2][0] * coordinates[0][1]) - (coordinates[0][1] * coordinates[1][0] + coordinates[1][1] * coordinates[2][0] + coordinates[2][1] * coordinates[0][0]));
    abs /= 2;
    System.out.println(String.format("%.2f", abs));
  }
}
