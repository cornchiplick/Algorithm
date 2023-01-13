package curriculum.stack_queue_deque;

import java.util.Arrays;
import java.util.Stack;

/**
 * 프로그래머스 - 스택/큐
 * lv2 - 주식가격
 * 전략
 * 1) 값, 수명, location을 요소로 갖는 stock(주식)객체를 만들어서 stack에 추가한다.
 * 2) 수명은 0에서 시작하며 매 사이클마다 1의 수명을 추가한다.(생존 시간 추가)
 * 3) stack안의 요소는 모두 점차 증가하는 방향으로 추가되어야 하며 그렇지 않을 경우 추가될 값보다 큰 요소를 모두 꺼낸다.
 * 4) 꺼내어진 요소가 있다면 그 요소의 수명을 기록한다.
 * 5) 더 이상 요소가 추가되지 않는다면 그 때까지 남아있는 요소들의 수명을 추가로 기록한다.
 * 6) 기록된 answer배열을 return한다.
 */
public class StockPrice {

  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 2, 3};
    int[] returns = {4, 3, 1, 1, 0};
    System.out.println(Arrays.toString(solution(prices)));

  }

  public static int[] solution(int[] prices) {
    Stack<Stock> st = new Stack<>();
    int[] answer = new int[prices.length];

    // prices의 모든 원소들을 차례로 검사
    for (int i = 0; i < prices.length; i++) {

      // stack안의 모든 원소들 수명 + 1
      for (Stock element : st) {
        element.life++;
      }

      // stack의 top과 비교해서 넣으려는 값이 크거나 같다면 push하고 while문 break;
      while (!st.isEmpty()) {
        if (st.peek().value <= prices[i]) {
          st.push(new Stock(prices[i], 0, i));
          break;
        }

        // stack의 top과 비교해서 넣으려는 값이 더 작다면 top의 수명을 answer에 옮기고 pop
        answer[st.peek().location] = st.peek().life;
        st.pop();
      }

      // 넣으려는 값이 stack안의 모든 값들보다 작다면 push되지 않고 넘어가므로 이 경우를 체크해줄것.
      if (st.isEmpty()) {
        st.push(new Stock(prices[i], 0, i));
      }
    }

    // 아직 stack안에 남아 있는(가장 작은 value를 갖는) 원소들에 대해 하나씩 꺼내주며 answer에 매핑
    while (!st.isEmpty()) {
      answer[st.peek().location] = st.peek().life;
      st.pop();
    }

    return answer;
  }
}

class Stock {
  Integer value;
  Integer life;
  int location;

  Stock(Integer value, Integer life, int location) {
    this.value = value;
    this.life = life;
    this.location = location;
  }

}
