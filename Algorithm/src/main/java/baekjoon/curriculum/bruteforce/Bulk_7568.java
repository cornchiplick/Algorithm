package baekjoon.curriculum.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bulk_7568 {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();

    // 몸무게와 키를 각각 원소로 갖는 이중배열 bulk 선언 및 초기화
    int N = Integer.parseInt(br.readLine());
    int[][] bulk = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer in = new StringTokenizer(br.readLine());
      bulk[i][0] = Integer.parseInt(in.nextToken());
      bulk[i][1] = Integer.parseInt(in.nextToken());
    }

    // 가장 덩치가 클 때 1등이므로 1부터 시작해서
    // 자신보다 덩치가 큰 사람이 있으면 순위(rank)가 1씩 밀린다.
    int rank = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (bulk[i][0] < bulk[j][0] && bulk[i][1] < bulk[j][1]) {
          rank++;
        }
      }
      out.append(rank).append(" ");

      // 다음 검사시 rank를 다시 1로 초기화
      rank = 1;
    }
    System.out.println(out);
  }


}
