package curriculum.stack_queue_deque;

import java.util.*;

/**
 * 프로그래머스 - 스택/큐
 * lv2 - 기능개발
 * 전략
 * 1) 모든 작업들에 대해 100% 완료까지 며칠 걸릴것인지 계산하여 큐에 추가
 * 2) 큐의 맨 앞에서부터 배포한다고 할 때, 동시에 몇 개의 기능까지 배포가 가능한지 센다.
 * 3) 2에서 세어준 기능의 개수를 return 배열에 추가한다.
 */
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

    // 100% 까지 며칠 걸릴것인지 계산
    int diff;
    for (int i = 0; i < progresses.length; i++) {
      diff = 100 - progresses[i];
      if (diff % speeds[i] != 0) {
        q.offer(diff / speeds[i] + 1);
      } else {
        q.offer(diff / speeds[i]);
      }
    }

    List<Integer> arr = new ArrayList<>();

    Integer temp;
    // 일단 하나 꺼내기
    int count = 1;
    while (q.size() > 0) {
      temp = q.remove();

      // 하나 꺼낼때 몇개나 딸려 나오는지
      while (!q.isEmpty() && temp >= q.peek()) {
        count++;
        q.remove();
      }
      arr.add(count);
      count = 1;

    }

    // 출력
    int[] answer = new int[arr.size()];
    for (int i = 0; i < arr.size(); i++) {
      answer[i] = arr.get(i);
    }

    return answer;
  }
}
