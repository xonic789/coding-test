package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] things = new int[n+1][2];
        int[][] dy = new int[n+1][k+1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
        }
        // 어떤걸 기록해야하는가..?
        // 무게를 0부터 7까지 늘려가며 나온 물건의 가치를 배낭에 넣을 수 있을 때를 기록한다.
        // 0번 인덱스의 무게는 6이고 가치가 13일 때,
        // dy 테이블의 1번 인덱스의 최대 가치는 배낭의 무게가 6일 때 가치는 13이다.
        // 2번 인덱스의 최대 가치는
        // 1.물건을 넣지 않았을 때
        // 2.물건을 넣었을 때 둘 중의 더 가치가 높은 쪽을 테이블에 기록한다.
        // 만약 현재 무게를 초과한다면 현재 무게의 최대 가치의 배낭은 dp 테이블의 이 전 인덱스가 된다.

        for (int i = 1; i <= n; i++) {
            // 무게를 1부터 k까지 1씩 증가시키는데, 그 이유는
            // 1부터 k까지 가장 최대의 가치를 dy i 인덱스의 j 무게를 기록해야 하기 때문.
            for (int j = 1; j <= k; j++) {
                // 현재 무게보다 물품의 무게가 더 무거울 경우에는
                // 이 전 테이블이 최대의 가치일 것이기 때문에 현재 테이블에 이 전 최대의 가치를 넣어준다.
                if (j < things[i][0]) {
                    dy[i][j] = dy[i - 1][j];
                // 현재 무게에서 물건은 넣을 수 있으므로
                // 이전 dy 테이블에서의 현재 무게 - 물건으로 테이블에 기록된 최대 가치를 더한 값과
                // 이전 dy 테이블에 기록된 현재 무게의 최대 가치와 비교하여 더 큰 값을 현재 무게의 dy 테이블에 기록한다.

                } else {
                    dy[i][j] = Math.max(things[i][1] + dy[i - 1][j - things[i][0]], dy[i - 1][j]);
                }
            }
        }
        System.out.println(dy[n][k]);
    }
}
