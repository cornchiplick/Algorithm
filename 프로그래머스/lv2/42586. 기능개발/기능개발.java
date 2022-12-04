import java.util.*;

class Solution {
public int[] solution(int[] progresses, int[] speeds) {
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