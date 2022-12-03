package programmerslv0;

import java.util.LinkedList;
import java.util.Queue;

public class PushString {

  public static void main(String[] args) {
    String a1 = "hello";
    String b1 = "ohell";
    int result1 = 1;
    System.out.println("1번 예시: " + solution(a1, b1));

    String a2 = "apple";
    String b2 = "elppa";
    int result2 = -1;
    System.out.println("2번 예시: " + solution(a2, b2));
  }

  public static int solution(String A, String B) {
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
