import java.util.*;
class Solution {
  public int solution(int n, int[][] wires) {
    int answer = 100;

    for (int i = 0; i < wires.length; i++) {
      // i번째 노드를 끊었을 때 양측의 수 차이
      int diff = cntBothSide(i, wires);

      // 차이가 가장 작은 경우 구하기
      answer = Math.min(answer, diff);

    }

    return answer;
  }
    
    private int cntBothSide(int index, int[][] wires) {
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
      } else {
        q.offer(q.poll());
      }
    }

    return Math.abs(part1.size() - part2.size());
  }
}