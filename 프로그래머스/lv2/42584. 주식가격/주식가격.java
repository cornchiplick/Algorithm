import java.util.*;

class Solution {
public int[] solution(int[] prices) {
    Stack<Stock> st = new Stack<>();
    int[] answer = new int[prices.length];

    st.push(new Stock(prices[0], 0, 0));
    for (int i = 1; i < prices.length; i++) {

      for (Stock element : st) {
        element.life++;
      }

      while (!st.isEmpty()) {
        if (st.peek().value <= prices[i]) {
          st.push(new Stock(prices[i], 0, i));
          break;
        }

        answer[st.peek().location] = st.peek().life;
        st.pop();
      }
        
        if (st.isEmpty()) {
        st.push(new Stock(prices[i], 0, i));
      }
    }

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