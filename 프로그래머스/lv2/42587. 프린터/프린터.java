import java.util.*;

class Solution {
public int solution(int[] priorities, int location) {
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