import java.util.*;

class Solution {
public int solution(String A, String B) {
    char[] a = A.toCharArray();
    char[] b = B.toCharArray();

    Queue qa = new LinkedList();
    Queue qb = new LinkedList();

    for (int i = 0; i < a.length; i++) {
      qa.offer(a[i]);
      qb.offer(b[i]);
    }

    for (int i = 1; i <= a.length; i++) {
      qa.offer(qa.poll());
      if (qa.equals(qb)) {
        return a.length-i;
      }
    }

    return -1;
  }
}