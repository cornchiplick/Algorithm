package curriculum.sort;

import java.util.Arrays;

/**
 * 프로그래머스 - 정렬
 * lv1 : K번째수
 */
public class KthNumber {
  public static void main(String[] args) {
    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
    int[] result = {5, 6, 3};
    System.out.println(Arrays.toString(solution(array, commands)));

  }

  public static int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for (int i = 0; i < commands.length; i++) {
      answer[i] = calculate(array, commands[i]);
    }

    return answer;
  }

  private static int calculate(int[] array, int[] command) {
    int[] arr = new int[command[1] - command[0] + 1];
    for (int i = command[0] - 1, j = 0; i < command[1]; i++, j++) {
      arr[j] = array[i];
    }

    Arrays.sort(arr);

    return arr[command[2]-1];
  }
}
