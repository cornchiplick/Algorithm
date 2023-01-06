package curriculum.bruteforce;

import java.util.Arrays;

public class MinSquare {
  public static void main(String[] args) {
    int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
    int result = 120;
    System.out.println(solution(sizes));

  }

  public static int solution(int[][] sizes) {
    int smallMax = 0;
    int bigMax = 0;

    for (int i = 0; i < sizes.length; i++) {
      // sizes의 원소 각각을 오름차순으로 정렬
      Arrays.sort(sizes[i]);

      // (가로 세로 중 작은 것)들 중 가장 큰 값 찾기
      if (sizes[i][0] >= smallMax) {
        smallMax = sizes[i][0];
      }
      // (가로 세로 중 큰 것)들 중 가장 큰 값 찾기
      if (sizes[i][1] >= bigMax) {
        bigMax = sizes[i][1];
      }
    }

    return smallMax * bigMax;
  }
}
