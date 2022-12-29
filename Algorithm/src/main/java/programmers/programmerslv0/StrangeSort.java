package programmers.programmerslv0;

import java.util.Arrays;

public class StrangeSort {

  public static void main(String[] args) {
    int[] numlist = {1, 2, 3, 4, 5, 6};
    int n = 4;
    System.out.println("1번 예시: " + Arrays.toString(solution(numlist, n)));
    int[] result = {4, 5, 3, 6, 2, 1};

    int[] numlist2 = {10000, 20, 36, 47, 40, 6, 10, 7000};
    int n2 = 30;
    System.out.println("2번 예시: " + Arrays.toString(solution(numlist2, n2)));
    int[] result2 = {36, 40, 20, 47, 10, 6, 7000, 10000};

  }

  public static int[] solution(int[] numlist, int n) {
    Integer[] sorted = new Integer[numlist.length];

    for (int i = 0; i < numlist.length; i++) {
      sorted[i] = numlist[i] - n;
    }

    Arrays.sort(sorted, (Integer o1, Integer o2) -> {
      if (Math.abs(o1) == Math.abs(o2)) {
        return o2 - o1;
      } else {
        return Math.abs(o1) - Math.abs(o2);
      }
    });

    int[] answer = new int[sorted.length];
    for (int i = 0; i < sorted.length; i++) {
      answer[i] = sorted[i] + n;
    }

    return answer;
  }
}
