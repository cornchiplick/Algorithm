package programmers.applytest;

import java.util.Arrays;

public class Bokgwon {
  public static void main(String[] args) {
    int[][] lotteries = {{10, 19, 800}, {20, 39, 200}, {100, 199, 500}}; // 당첨자 수, 구매한 사람 수, 당첨 금액
    System.out.println(solution(lotteries)); // 2
  }

  public static int solution(int[][] lotteries) {
    double[][] p = new double[lotteries.length][3];

    for (int i = 0; i < lotteries.length; i++) {
      if (lotteries[i][0] >= lotteries[i][1] + 1) {
        p[i][0] = 1;
        p[i][1] = i;
        p[i][2] = lotteries[i][2];
      } else {
        p[i][0] = (double) lotteries[i][0] / (lotteries[i][1] + 1);
        p[i][1] = i;
        p[i][2] = lotteries[i][2];
      }
    }

    Arrays.sort(p, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        if (o1[2] - o2[2] > 0) {
          return 1;
        } else if (o1[2] - o2[2] < 0) {
          return -1;
        } else {
          return 0;
        }
      } else {
        if (o1[0] - o2[0] > 0) {
          return 1;
        } else if (o1[0] - o2[0] < 0) {
          return -1;
        } else {
          return 0;
        }
      }
    });

    return (int) p[p.length - 1][1] + 1;
  }
}
