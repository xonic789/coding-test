package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goorm_A4용지를만들자 {

  // N M 에 해당하는 용지를 가로 세로로 A4용지가 몇 개로 나눠지는지 구한 후
  // 두 수를 더하고, 중복된 영역을 빼준다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    long N = Long.parseLong(s[0]);
    long M = Long.parseLong(s[1]);
    int width = 20;
    int height = 40;
    long A = (N / width) * (M / height);
    long B = (N / height) * (M / width);
    long sumSet = ((N / 40) * (M / 40)) * 2;
    System.out.println(A + B - sumSet);
  }
}
