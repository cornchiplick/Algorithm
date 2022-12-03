class Solution {
public int[] solution(int[][] score) {
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