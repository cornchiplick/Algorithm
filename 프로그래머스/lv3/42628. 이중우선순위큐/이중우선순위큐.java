import java.util.*;

class Solution {
public int[] solution(String[] operations) {
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