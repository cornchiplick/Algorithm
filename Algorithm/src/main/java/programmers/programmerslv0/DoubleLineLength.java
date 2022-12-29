package programmers.programmerslv0;

import java.util.Arrays;

public class DoubleLineLength {

  public static void main(String[] args) {
    int[][] lines = {{0, 5}, {3, 9}, {1, 10}};
    int result = 8;
    System.out.println(solution(lines));

  }

  public static int solution(int[][] lines) {
    int answer = 0;

    Arrays.sort(lines, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1]-o2[1];
      } else {
        return o1[0]-o2[0];
      }
    });

    int max;
    if (lines[0][1] > lines[1][1]) {
      max = lines[0][1];
    } else {
      max = lines[1][1];
    }
    if (max < lines[2][1]) {
      max = lines[2][1];
    }

    int count = 0;
    for (int i = lines[0][0]; i < max; i++) {
      for (int j = 0; j < lines.length; j++) {
        if (i >= lines[j][0] && i+1 <= lines[j][1]) {
          count++;
        }
      }
      if (count > 1) {
        answer++;
      }
      count = 0;
    }
    return answer;
  }
}
