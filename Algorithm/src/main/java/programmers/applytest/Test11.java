package programmers.applytest;

import java.util.Arrays;

public class Test11 {
  public static void main(String[] args) {

    int[] arr = new int[4];
    long a = 2323233;
    System.out.println(Arrays.toString(solution(a)));

  }

  static int[] solution(long a) {
    int[] answer = new int[10];

    String str = String.valueOf(a);
    for (int i = 0; i < str.length(); i++) {
      for (int j = 0; j < 10; j++) {
        if (str.charAt(i) - '0' == j) {
          answer[j]++;
        }
      }
    }

    return answer;
  }
}
