import java.util.*;
class Solution {
    boolean solution(String s) {
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