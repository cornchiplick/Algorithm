package programmers.programmers_stack_queue;

import java.util.Stack;

public class CorrectBrackets {

  public static void main(String[] args) {
    String s = "(()(";
    boolean answer = false;
    System.out.println(solution(s));

  }

  static boolean solution(String s) {
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        st.add(1);
      } else {
        if (st.size() != 0) {
          st.pop();
        } else {
          return false;
        }
      }
    }

    if (st.size() != 0) {
      return false;
    }
    return true;
  }
}
