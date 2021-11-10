package week1;

import java.util.Scanner;

public class BOJ_12865_평범한배낭1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        // 물건을 기록한다.
        int[][] things = new int[N][2];
        for (int i = 0; i < N; i++) {
            things[i][0] = sc.nextInt();
            things[i][1] = sc.nextInt();
        }
        // 0번 인덱스부터 최대 가치를 담을 테이블.
        int[][] dy = new int[N][K + 1];

        for (int i = 0; i < N; i++) {
            int weight = things[i][0];
            int value = things[i][1];
            // 무게를 1부터 하나씩 증가 시켜가면서
            // 최대 가치를 담는다.
            for (int j = 1; j <= K; j++) {
                if (i == 0) {
                    // 맨 처음일 경우 현재 무게를 배낭에 넣을 수 있다면
                    // 현재 가치가 최대 j 무게에서 가지는 최대 가치이다.
                    if (weight <= j) dy[i][j] = value;
                    continue;
                }
                // 물건의 무게가 현재 배낭의 무게보다 클 경우,
                if (weight > j) {
                    // 이전의 최대 가치를 담는다.
                    dy[i][j] = dy[i - 1][j];
                } else {
                    // 넣을 수 있다면, 물건의 가치 + 이 전의 dy 에 기록된 최대 가치
                    // (현재 무게 - 물건의 무게) 를 통해 넣을 수 있는 최대 가치를 현재 물건의 가치와 더한 값과,
                    // 현재 무게의 이 전의 dy에 기록된 최대 가치를 비교하여 더 큰 값을 현재 dy 테이블에 넣는다.
                    dy[i][j] = Math.max(value + dy[i - 1][j - things[i][0]], dy[i - 1][j]);
                }
            }
        }
        System.out.println(dy[N - 1][K]);
    }
}
