package curriculum.stack_queue_deque;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 - 스택/큐
 * lv2 - 프린터
 * 전략
 * 1) 위치(location)와 중요도(prior)를 요소로 갖는 객체를 큐에 저장한다.
 * 2) 큐의 모든 요소를 검사해서 큐의 맨 앞 객체보다 prior가 높은 문서가 존재한다면 큐의 맨 뒤로 보낸다.
 * 3) 그렇지 않다면 큐에서 제거하기 전에 입력받은 location과 객체의 location을 비교한다.
 * 4) 두 location이 일치한다면 count 변수에 저장된 값을 리턴하고, 그렇지 않다면 count를 1증가시킨다.
 */
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

    // 전략 1)
    for (int i = 0; i < priorities.length; i++) {
      q.offer(new Print(i,priorities[i]));
    }

    int count = 1;

    // 전략 2)
    while (!q.isEmpty()) {
      int prior = q.peek().prior;
      boolean condition = true;

      for (Print prt: q) {
        if (prior < prt.prior) {
          condition = false;
        }
      }

      // 전략 3)
      if (condition) {
        if (q.peek().location == location) {
          return count;
        } else { // 전략 4)
          count++;
          q.poll();
        }
      } else { // 전략 2)
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
