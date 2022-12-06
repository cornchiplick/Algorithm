package programmers_stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {

  public static void main(String[] args) {
    int bridge_length1 = 2;
    int weight1 = 10;
    int[] truck_weights1 = {7, 4, 5, 6};
    int result1 = 8;
    System.out.println("1번 예시: " + solution(bridge_length1, weight1, truck_weights1));

    int bridge_length2 = 100;
    int weight2 = 100;
    int[] truck_weights2 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    int result2 = 110;
    System.out.println("2번 예시: " + solution(bridge_length2, weight2, truck_weights2));

  }

  public static int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Truck> line = new LinkedList<>();
    Queue<Truck> over = new LinkedList<>();

    for (int element : truck_weights) {
      line.offer(new Truck(element, 0));
    }

    // 시간 경과
    int count = 1;

    // over Queue에 첫번째 원소 세팅
    // 다리 위에 가해지는 하중
    int wei = line.peek().gravity;
    line.peek().location++;
    over.offer(line.poll());

    // over Queue가 빌 때까지 진행
    while (!over.isEmpty()) {
      count++;

      // 다리 위에 있는 모든 트럭들 1칸 전진
      for (Truck element : over) {
        element.location++;
      }

      // 다리 위, 맨 앞 트럭이 다리를 지났는지 확인하기
      if (over.peek().location > bridge_length) {
        // 지났으면 다리에 가해지는 하중에서 트럭무게만큼 빼기
        wei -= over.peek().gravity;
        // 다리에서 트럭 제거
        over.poll();
      }

      // 대기열이 비어있는지 확인
      if (!line.isEmpty()) {
        // 비었으면 다리위에 가해지는 하중에 더 추가해도 되는지 확인
        if (wei + line.peek().gravity <= weight) {
          // 괜찮으면 다리 위에 올리기
          line.peek().location++;
          wei += line.peek().gravity;
          over.offer(line.poll());
        }
      }
    }

    return count;
  }
}

class Truck {
  int gravity;
  int location;

  Truck(int gravity, int location) {
    this.gravity = gravity;
    this.location = location;
  }
}
