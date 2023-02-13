package programmers.applytest;

import java.util.Arrays;

public class Palindrome {
  public static void main(String[] args) {
    int[][] queries1 = {{2, 0}, {3, 1}};
    System.out.println(Arrays.toString(solution(queries1))); // 0, 0

    int[][] queries2 = {{1, 4, 3}, {1, 2, 2}};
    System.out.println(Arrays.toString(solution(queries2))); // 0, 1

  }
// 0 1 2 1
  public static int[] solution(int[][] queries) {
    int[] answer = new int[queries.length];
    int sum = 0;

    for (int i = 0; i < queries.length; i++) {
      sum = 0;
      for (int j = 0; j < queries[i].length; j++) {
        sum += queries[i][j];
      }

      if (sum % 2 == 1) {
        answer[i] = 1;
      }
    }
    return answer;
  }

    /* // 중간을 기점으로 양변의 숫자가 같게 만들기위해 필요한 턴수 계산하는 문제
    int[] answer = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      // 포인터 설정
      int hi;
      if (queries[i].length % 2 == 0) {
        hi = queries[i].length / 2;
      } else {
        hi = queries[i].length / 2 + 1;
      }
      int lo = queries[i].length / 2 - 1;

      // 승리하기 위해 턴을 넘기는 경우 정가운데의 수를 뺄것이다. 이는 양측 모두 동일하다. 따라서 중간값도 고려해주어야 한다.
      int mid = -1;
      if (queries[i].length % 2 == 1) {
        mid = queries[i].length / 2;
      }
      int sum = 0;

      // 펠린드롬수를 만들기 위한 총 필요 턴수 계산
      while (lo >= 0) {
        sum += Math.abs(queries[i][hi] - queries[i][lo]);
        lo--;
        hi++;
      }

      if (mid > 0) {
        sum += queries[i][mid];
      }

      // 첫 플레이어가 먼저 시작하므로 sum이 홀수일때만 승리할 수 있다.
      if (sum % 2 == 1) {
        answer[i] = 1;
      }
    }

    return answer;
  }*/
}
