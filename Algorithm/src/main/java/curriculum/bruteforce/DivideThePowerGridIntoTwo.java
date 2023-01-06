package curriculum.bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DivideThePowerGridIntoTwo {

  public static void main(String[] args) {
    int n1 = 9;
    int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
    int result1 = 3;
    System.out.println(solution(n1, wires1));

    int n2 = 7;
    int[][] wires2 = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
    int result2 = 1;
    System.out.println(solution(n2, wires2));

  }

  public static int solution(int n, int[][] wires) {
    int answer = 100;

    for (int i = 0; i < wires.length; i++) {
      // i번째 노드를 끊었을 때 양측의 수 차이
      int diff = cntBothSide(i, wires);

      // 차이가 가장 작은 경우 구하기
      answer = Math.min(answer, diff);

    }

    return answer;
  }

  private static int cntBothSide(int index, int[][] wires) {
    // wires배열의 index 저장: 어느 part에 속하는지 체크되지 않은 요소만 있다.
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < wires.length; i++) {
      if (i != index) {
        q.offer(i);
      }
    }
    // 절단면 기준으로 두 part가 생긴다.
    List<Integer> part1 = new ArrayList<>();
    part1.add(wires[index][0]);

    List<Integer> part2 = new ArrayList<>();
    part2.add(wires[index][1]);

    // 어느 파트에 속하는지 판별 후 분류하기
    while (!q.isEmpty()) {
      if (part1.contains(wires[q.peek()][0])) {
        part1.add(wires[q.peek()][1]);
        q.poll();
      } else if (part1.contains(wires[q.peek()][1])) {
        part1.add(wires[q.peek()][0]);
        q.poll();
      } else if (part2.contains(wires[q.peek()][0])) {
        part2.add(wires[q.peek()][1]);
        q.poll();
      } else if (part2.contains(wires[q.peek()][1])) {
        part2.add(wires[q.peek()][0]);
        q.poll();
        // 어디에도 속하지 않으면 q의 맨 뒤로 보낸다.
      } else {
        q.offer(q.poll());
      }
    }

    // 두 파트의 차를 구한다.
    return Math.abs(part1.size() - part2.size());
  }

}
