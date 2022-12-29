package programmers.programmers_stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HateSameNum {

  public static void main(String[] args) {
    int[] arr = {1, 1, 3, 3, 0, 1, 1};
    int[] result = {1, 3, 0, 1};
    System.out.println(Arrays.toString(solution(arr)));

  }

  public static int[] solution(int[] arr) {
    int[] answer;
    int n = arr.length;

    Queue<Integer> q = new LinkedList<>();
    for (int element : arr) {
      q.offer(element);
    }

    Integer temp = q.remove();
    q.offer(temp);

    Integer temp2;
    for (int i = 1; i < n; i++) {
      temp2 = q.poll();
      if (!temp2.equals(temp)) {
        q.offer(temp2);
        temp = temp2;
      }
    }

    int m = q.size();
    answer = new int[m];

    for (int i = 0; i < m; i++) {
      answer[i] = q.poll();
    }

    return answer;
  }
}
