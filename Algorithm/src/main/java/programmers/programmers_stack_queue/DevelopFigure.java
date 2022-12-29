package programmers.programmers_stack_queue;

import java.util.*;

public class DevelopFigure {

  public static void main(String[] args) {
    int[] progresses1 = {93, 30, 55};
    int[] speeds1 = {1, 30, 5};
    System.out.println("1번 예시: " + Arrays.toString(solution(progresses1, speeds1)));
    int[] result1 = {2, 1};

    int[] progresses2 = {95, 90, 99, 99, 80, 99};
    int[] speeds2 = {1, 1, 1, 1, 1, 1};
    System.out.println("2번 예시: " + Arrays.toString(solution(progresses2, speeds2)));
    int[] result2 = {1, 3, 2};
  }

  public static int[] solution(int[] progresses, int[] speeds) {
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < progresses.length; i++) {
      int diff = 100-progresses[i];
      if (diff % speeds[i] != 0) {
        q.offer(diff / speeds[i] + 1);
      } else {
        q.offer(diff / speeds[i]);
      }
    }

    List<Integer> arr = new ArrayList<>();

    Integer temp;
    int count = 1;
    while (q.size() > 0) {
      temp = q.remove();
      while (!q.isEmpty() && temp >= q.peek()) {
        count++;
        q.remove();
      }
      arr.add(count);
      count = 1;

    }

    int[] answer = new int[arr.size()];
    for (int i = 0; i < arr.size(); i++) {
      answer[i] = arr.get(i);
    }

    return answer;
  }
}
