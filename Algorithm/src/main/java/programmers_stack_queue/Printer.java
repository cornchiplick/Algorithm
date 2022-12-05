package programmers_stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {

  public static void main(String[] args) {
    int[] priorities1 = {2, 1, 3, 2};
    int location1 = 2;
    int result1 = 1;
    System.out.println("1번 예시: " + solution(priorities1, location1));

    int[] priorities2 = {1, 1, 9, 1, 1, 1};
    int location2 = 0;
    int result2 = 5;
    System.out.println("2번 예시: " + solution(priorities2, location2));

  }

  public static int solution(int[] priorities, int location) {
    Queue<Print> q = new LinkedList<>();

    for (int i = 0; i < priorities.length; i++) {
      q.offer(new Print(i,priorities[i]));
    }

    int count = 1;

    while (!q.isEmpty()) {
      int prior = q.peek().prior;
      boolean condition = true;

      for (Print prt: q) {
        if (prior < prt.prior) {
          condition = false;
        }
      }

      if (condition) {
        if (q.peek().location == location) {
          return count;
        } else {
          count++;
          q.poll();
        }
      } else {
        q.offer(q.poll());
      }
    }

    return 0;
  }

}

class Print {
  int location;
  int prior;

  Print(int location, int prior) {
    this.location = location;
    this.prior = prior;
  }
}
