package programmers_stack_queue;

import java.util.Arrays;
import java.util.Stack;

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
