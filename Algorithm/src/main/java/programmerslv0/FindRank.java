package programmerslv0;

import java.util.Arrays;

public class FindRank {

  public static void main(String[] args) {
    int[][] score = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
    int[] result = {4, 4, 6, 2, 2, 1, 7};
    System.out.println(Arrays.toString(solution(score)));

  }

  public static int[] solution(int[][] score) {
    double[] avg = new double[score.length];
    int[] answer = new int[score.length];

    for (int i = 0; i < score.length; i++) {
      avg[i] = ((double) score[i][0] + (double) score[i][1])/2;
    }

    int count = 1;
    for (int i = 0; i < avg.length; i++) {
      for (int j = 0; j < avg.length; j++) {
        if (avg[i] < avg[j]) {
          count++;
        }
      }
      answer[i] = count;
      count = 1;
    }

    return answer;
  }
}
