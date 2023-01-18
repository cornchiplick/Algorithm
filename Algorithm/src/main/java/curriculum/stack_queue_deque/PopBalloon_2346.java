package curriculum.stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 - 2346
 * 실버III - 풍선 터뜨리기
 * 전략
 * 순차적인 데이터의 추가 및 삭제에는 LinkedList보다 ArrayDeque를 이용하는 것이 더 효과적이다.
 * 1) 덱으로 양수면 앞에서 부터 세고, 음수면 뒤에서 부터 세어서 offer, poll 반복해준다.
 * 2) 자신의 index와 다음 풍선을 가리키는 pointer를 Balloon객체에 담는다.
 * 3) 터트린 풍선은 poll, poll된 풍선의 pointer로 다음 poll 할 풍선을 찾는다.
 */
public class PopBalloon_2346 {
  private static Deque<Balloon> dq = new ArrayDeque<>();
  private static StringBuilder sb = new StringBuilder();


  public static void main(String[] args) throws IOException {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      dq.offerFirst(new Balloon(i, Integer.parseInt(st.nextToken())));
    }

    br.close();

    // 풍선객체와 다음 풍선을 가리키는 포인터
    Balloon ans;
    int next = 0;

    // 덱이 빌때까지 반복
    while (!dq.isEmpty()) {
      // 포인터의 부호 판별 후, 덱에 적절한 처리
      if (next >= 0) {
        for (int i = 0; i < next - 1; i++) {
          dq.offerFirst(dq.pollLast());
        }
        ans = dq.pollLast();
      } else {
        for (int i = 0; i < -next - 1; i++) {
          dq.offerLast(dq.pollFirst());
        }
        ans = dq.pollFirst();
      }

      // 현재 풍선의 번호를 출력하고, 다음 타겟 풍선 설정
      sb.append(ans.index).append(' ');
      next = ans.pointer;
    }

    // 최종 출력
    System.out.println(sb);

  }

  static class Balloon {
    int index;
    int pointer;

    Balloon(int index, int pointer) {
      this.index = index;
      this.pointer = pointer;
    }

  }
}
