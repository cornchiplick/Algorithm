package programmers_heap;

import java.util.PriorityQueue;

public class SpicyMore {

  public static void main(String[] args) {
    int[] scoville = {1, 2, 3, 9, 10, 12};
    int K = 7;
    int result = 2;
    System.out.println(solution(scoville, K));

  }

  public static int solution(int[] scoville, int K) {
    int answer = 0;

    PriorityQueue<Integer> heap = new PriorityQueue<>();

    for (int element : scoville) {
      heap.offer(element);
    }

    while (heap.peek() <= K) {
      if (heap.size() == 1) {
        return -1;
      }

      heap.offer(heap.poll() + heap.poll() * 2);
      answer++;

    }

    return answer;
  }
}