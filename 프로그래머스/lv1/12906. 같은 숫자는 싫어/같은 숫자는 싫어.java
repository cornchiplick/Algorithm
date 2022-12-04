import java.util.*;

public class Solution {
public int[] solution(int[] arr) {
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