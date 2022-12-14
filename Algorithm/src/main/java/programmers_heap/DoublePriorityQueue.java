package programmers_heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

  public static void main(String[] args) {
    String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    int[] return1 = {0, 0};
    System.out.println("결과1 : " + Arrays.toString(solution(operations1)));

    String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
    int[] return2 = {333, -45};
    System.out.println("결과2 : " + Arrays.toString(solution(operations2)));

  }

  public static int[] solution(String[] operations) {
    PriorityQueue<Integer> minq = new PriorityQueue<>();
    PriorityQueue<Integer> maxq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    for (int i = 0; i < operations.length; i++) {
      switch (operations[i].charAt(0)) {
        case 'I' : {
          minq.offer(Integer.parseInt(operations[i].substring(2)));
          maxq.offer(Integer.parseInt(operations[i].substring(2)));
          break;
        }
        case 'D' : {
          if (!minq.isEmpty()) {
            if (Integer.parseInt(operations[i].substring(2)) > 0) {
              Integer temp = maxq.poll();
              minq.remove(temp);
            } else {
              Integer temp = minq.poll();
              maxq.remove(temp);
            }
          }
          break;
        }
      }
    }
    int[] answer = new int[2];

    if (minq.isEmpty()) {
      answer[0] = 0;
      answer[1] = 0;
    } else {
      answer[0] = maxq.peek();
      answer[1] = minq.peek();
    }

    return answer;
  }
}
