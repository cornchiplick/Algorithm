package baekjoon.curriculum.bruteforce;

import java.util.Arrays;

public class Carpet {
  public static void main(String[] args) {
    int brown = 24;
    int yellow = 24;
    int[] result = {8, 6};
    System.out.println(Arrays.toString(solution(brown, yellow)));

  }

  public static int[] solution(int brown, int yellow) {
    int ans1 = 0;
    int ans2 = 0;

    int limit = (int) Math.sqrt(yellow);
    // yellow를 두 인수로 인수분해 : 최대인수 <= sqrt(yellow)
    for (int i = 1; i <= limit; i++) {
      // 올바른 두 인수를 찾기
      if (yellow % i == 0) {
        if ((i + 2) * (yellow / i + 2) - yellow == brown) {
          ans1 = yellow / i + 2;
          ans2 = i + 2;
          break;
        }
      }
    }

    return new int[]{ans1, ans2};
  }

}
